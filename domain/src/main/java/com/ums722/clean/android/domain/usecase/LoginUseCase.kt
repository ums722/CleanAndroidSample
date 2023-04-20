package com.ums722.clean.android.domain.usecase

import com.ums722.clean.android.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.ums722.clean.android.domain.common.Result
import com.ums722.clean.android.domain.entity.Entity


class LoginUseCase @Inject constructor(val authRepository: AuthRepository) {
    suspend operator fun invoke(id: String, password: String): Flow<Result<Entity>> = authRepository.login(id, password)

}