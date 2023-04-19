package com.ums722.clean.android.domain.repository

import kotlinx.coroutines.flow.Flow
import com.ums722.clean.android.domain.common.Result
import com.ums722.clean.android.domain.entity.Entity


interface AuthRepository {
    suspend fun login(id: String, password: String): Flow<Result<Entity>>
}