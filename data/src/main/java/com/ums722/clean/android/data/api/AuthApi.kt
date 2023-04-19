package com.ums722.clean.android.data.api

import com.google.gson.JsonObject
import com.ums722.clean.android.data.model.LoginRes
import org.w3c.dom.Entity
import retrofit2.http.*

interface AuthApi {

    @POST("login")
    suspend fun login(
        @Body loginReq: JsonObject
    ): LoginRes

    @POST("logout")
    suspend fun logout(): Unit

    @POST("signup")
    suspend fun register(
        @Body registerRequest: Entity
    ): Unit

    @GET("check-id")
    suspend fun idCheck(
        @Query("login-id") id: String
    ): Entity

    @PUT("password/reset")
    suspend fun changePassword(
        @Body changePasswordReq: Entity
    ): Unit
}

