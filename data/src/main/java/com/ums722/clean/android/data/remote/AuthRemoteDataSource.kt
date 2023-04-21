package com.ums722.clean.android.data.remote

import com.ums722.clean.android.data.api.AuthApi
import com.ums722.clean.android.data.model.LoginRes
import kotlinx.coroutines.flow.Flow
import com.ums722.clean.android.domain.common.Result

internal interface AuthRemoteDataSource {

    fun login(id: String, password: String): Flow<Result<LoginRes>>
}