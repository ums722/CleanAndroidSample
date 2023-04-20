package com.ums722.clean.android.data.common

import com.google.gson.Gson
import com.orhanobut.logger.Logger
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import retrofit2.HttpException
import java.net.UnknownHostException
import com.ums722.clean.android.domain.entity.Entity
import com.ums722.clean.android.domain.common.Result

//todo 나중에 에러바디 엔티티 추가해서 예외처리해줘야함
fun <T> Flow<T>.apiCatch(producerScope: ProducerScope<Result<Entity>>): Flow<T> {
    return this.catch { cause: Throwable ->
        when (cause) {
            is HttpException -> {
                Gson().let { gson ->
                    try {


                    } catch (errorResponse: Exception) {

                    }
                }
            }
            is UnknownHostException -> {

            }
            else -> {
                Logger.d("HttpException cause ${cause}")
            }
        }
    }
}