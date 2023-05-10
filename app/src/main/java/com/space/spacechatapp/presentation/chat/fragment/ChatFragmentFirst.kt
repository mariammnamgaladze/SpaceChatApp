package com.space.spacechatapp.presentation.chat.fragment

import com.space.spacechatapp.presentation.base.BaseChatFragment

class ChatFragmentFirst : BaseChatFragment() {
    override fun userID(): String = "FirstFragment"
}

class ChatFragmentSecond : BaseChatFragment() {
    override fun userID(): String = "SecondFragment"
}