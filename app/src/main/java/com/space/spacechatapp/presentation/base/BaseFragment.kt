package com.space.spacechatapp.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import kotlin.reflect.KClass

abstract class BaseFragment<VM : ViewModel>(@LayoutRes layout: Int) : Fragment(layout) {
    abstract val viewModelClass: KClass<VM>
    private val viewModel: VM by viewModelForClass(clazz = viewModelClass)
    protected val listener = object : AdapterListener {
        override val getUserId: () -> String
            get() = { userId }
    }
    protected val userId get() = userId()
    abstract fun userId(): String
    abstract fun onBind(viewModel: VM)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind(viewModel)
    }
}