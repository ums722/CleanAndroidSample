package com.ums722.clean.android.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ums722.clean.android.domain.entity.LoginResEntity
import com.ums722.clean.android.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.ums722.clean.android.domain.common.Result
import com.ums722.clean.android.sample.common.asEntityType

@HiltViewModel
class MainViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    fun login(id: String, password: String) {
        viewModelScope.launch {
            loginUseCase(id, password).collectLatest { response ->
                when (response) {

                    is Result.Loading -> {
                    }

                    is Result.Success -> {
                        val result = response.value.asEntityType<LoginResEntity>()
                    }

                    is Result.Error -> {

                    }
                }
            }
        }
    }
}