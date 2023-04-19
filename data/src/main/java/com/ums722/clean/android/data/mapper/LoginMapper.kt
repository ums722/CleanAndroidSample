package com.ums722.clean.android.data.mapper

import com.ums722.clean.android.data.model.LoginRes
import com.ums722.clean.android.domain.entity.LoginResEntity

internal object  LoginMapper {

    fun LoginRes.toEntity() =
        LoginResEntity(accessToken = accessToken)
}