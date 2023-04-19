package com.ums722.clean.android.domain.common

import com.ums722.clean.android.domain.entity.Entity

sealed class Result<in T> {
    object Loading : Result<Entity>()
    data class Success<T>(val value: T) : Result<T>()
    data class Error(val exception: Entity) : Result<Entity>()
}