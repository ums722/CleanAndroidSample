package com.ums722.clean.android.data.module

import com.ums722.clean.android.data.BuildConfig
import com.ums722.clean.android.data.api.AuthApi
import com.ums722.clean.android.data.remote.AuthRemoteDataSource
import com.ums722.clean.android.data.remote.AuthRemoteDataSourceImpl
import com.ums722.clean.android.data.repository.AuthRepositoryImpl
import com.ums722.clean.android.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteDataModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
            setLevel(HttpLoggingInterceptor.Level.HEADERS)
        }

    //todo 주소 입력
    @Provides
    @Singleton
    fun provideAuthRetrofit(loggingInterceptor: HttpLoggingInterceptor): AuthApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.DEV_API)
            .client(OkHttpClient.Builder().also { client ->
                client.addInterceptor(loggingInterceptor)
                client.connectTimeout(10, TimeUnit.SECONDS)
                client.readTimeout(10, TimeUnit.SECONDS)
                client.callTimeout(10, TimeUnit.SECONDS)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(authApi: AuthApi): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authApi = authApi)

    @Provides
    @Singleton
    fun provideAuthRepository(@IoDispatcher ioDispatcher: CoroutineDispatcher, authRemoteDataSource: AuthRemoteDataSource): AuthRepository = AuthRepositoryImpl(ioDispatcher, authRemoteDataSource)

}