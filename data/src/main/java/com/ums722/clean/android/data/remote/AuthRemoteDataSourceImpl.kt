package com.ums722.clean.android.data.remote

import com.google.gson.JsonObject
import com.ums722.clean.android.data.api.AuthApi
import com.ums722.clean.android.data.model.LoginRes
import kotlinx.coroutines.flow.Flow
import com.ums722.clean.android.domain.common.Result
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authApi: AuthApi) : AuthRemoteDataSource {

    // todo api와 통신 구현체에 제이슨오브젝트 말고 dataClass or 좀더 나은 방법을 찾아야 겠다.
    override  fun login(id: String, password: String): Flow<Result<LoginRes>> = flow{
        emit(Result.Success(authApi.login(JsonObject())))
    }
}