package com.space.chatapp.presentation.chat.fragment

import com.space.chatapp.presentation.base.BaseChatFragment

class ChatFragmentFirst : BaseChatFragment() {
    override fun userID(): String = "FirstFragment"
}

class ChatFragmentSecond : BaseChatFragment() {
    override fun userID(): String = "SecondFragment"
}