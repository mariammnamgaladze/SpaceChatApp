package com.example.spacechatapp.presentation.bottom

import androidx.fragment.app.viewModels
import com.example.spacechatapp.databinding.FragmentBottomBinding
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflate

class BottomFragment : BaseFragment<FragmentBottomBinding>() {
    private val viewModel: BottomFragmentViewModel by viewModels()
    override fun inflate(): Inflate<FragmentBottomBinding> {
        return FragmentBottomBinding::inflate
    }

    override fun onBind() {
    }

}