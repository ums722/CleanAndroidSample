package com.ums722.clean.android.sample.common

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ums722.clean.android.domain.entity.Entity
import kotlinx.coroutines.CoroutineScope

fun LifecycleOwner.launchRepeatStarted(block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launchWhenCreated {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            block()
        }
    }
}

inline fun <reified T : Entity> Entity.asEntityType() = this as T
