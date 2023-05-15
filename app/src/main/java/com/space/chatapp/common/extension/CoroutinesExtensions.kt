package com.space.chatapp.common.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


fun ViewModel.viewModelScope(
    block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch { block() }
}

fun Fragment.lifecycleScope(block: suspend CoroutineScope.() -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        block()
    }
}