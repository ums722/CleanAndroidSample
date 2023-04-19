package com.ums722.clean.android.data.repository

import com.ums722.clean.android.data.common.apiCatch
import com.ums722.clean.android.data.mapper.LoginMapper.toEntity
import com.ums722.clean.android.data.module.IoDispatcher
import com.ums722.clean.android.data.remote.AuthRemoteDataSource
import com.ums722.clean.android.domain.common.Result
import com.ums722.clean.android.domain.entity.Entity
import com.ums722.clean.android.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class AuthRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {

    override suspend fun login(id: String, password: String): Flow<Result<Entity>> = channelFlow {
        withContext(ioDispatcher) {
            send(Result.Loading)

            authRemoteDataSource.login(id, password).map {
                (it as Result.Success).value.toEntity()
            }.map { Result.Success(it as Entity) }

        }.apiCatch(this).collectLatest { result ->
            send(result)
        }
        awaitClose()

    }
}