package com.space.spacechatapp.presentation.chat.fragment

import com.space.spacechatapp.presentation.base.BaseChatFragment

/**
 *The ChatFragmentFirst and ChatFragmentSecond classes are both subclasses of the BaseChatFragment class,
 *which means they inherit its properties and methods. However, they both override the userID() method to provide a unique ID for each fragment.
 */
class ChatFragmentFirst : BaseChatFragment() {
    override fun userID(): String = "FirstFragment"
}

class ChatFragmentSecond : BaseChatFragment() {
    override fun userID(): String = "SecondFragment"
}