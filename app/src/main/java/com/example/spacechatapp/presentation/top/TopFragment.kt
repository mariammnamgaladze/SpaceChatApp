package com.example.spacechatapp.presentation.top

import androidx.fragment.app.viewModels
import com.example.spacechatapp.databinding.FragmentTopBinding
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflate


class TopFragment : BaseFragment<FragmentTopBinding, TopFragmentViewModel>() {
    override val viewModel by viewModels<TopFragmentViewModel>()
    override fun inflate(): Inflate<FragmentTopBinding> {
        return FragmentTopBinding::inflate
    }

    override fun onBind(viewModel: TopFragmentViewModel) {
    }
}