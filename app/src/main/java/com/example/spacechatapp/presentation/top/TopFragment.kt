package com.example.spacechatapp.presentation.top

import androidx.fragment.app.viewModels
import com.example.spacechatapp.databinding.FragmentTopBinding
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflate


class TopFragment : BaseFragment<FragmentTopBinding>() {
    private val viewModel: TopFragmentViewModel by viewModels()
    override fun inflate(): Inflate<FragmentTopBinding> {
        return FragmentTopBinding::inflate
    }

    override fun onBind() {
    }

}