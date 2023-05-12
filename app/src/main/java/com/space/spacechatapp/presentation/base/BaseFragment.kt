package com.space.spacechatapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import kotlin.reflect.KClass

/**
 * This is an abstract class that serves as a base for creating fragments in an Android app.
 * The class defines some common functionality for all fragments, such as inflating the fragment layout,
 * initializing the ViewModel, and binding the ViewModel to the UI.
 */
abstract class BaseFragment<VM : ViewModel> : Fragment() {
    abstract val viewModelClass: KClass<VM>
    private val viewModel: VM by viewModelForClass(clazz = viewModelClass)
    protected abstract val layout: Int
    abstract fun onBind(viewModel: VM)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind(viewModel)
    }
}