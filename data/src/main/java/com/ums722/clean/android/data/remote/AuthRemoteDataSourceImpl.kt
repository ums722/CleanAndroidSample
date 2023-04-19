package com.ums722.clean.android.data.remote

import com.google.gson.JsonObject
import com.ums722.clean.android.data.api.AuthApi
import com.ums722.clean.android.data.model.LoginRes
import kotlinx.coroutines.flow.Flow
import com.ums722.clean.android.domain.common.Result
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authApi: AuthApi) : AuthRemoteDataSource {
    override suspend fun login(id: String, password: String): Flow<Result<LoginRes>> = flow{
        emit(Result.Success(authApi.login(JsonObject())))
    }
}