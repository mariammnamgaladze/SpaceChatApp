package com.space.spacechatapp.presentation.adapter

import android.view.View
import com.space.spacechatapp.R
import com.space.spacechatapp.common.extension.*
import com.space.spacechatapp.databinding.ChatMessageLayoutItemBinding
import com.space.spacechatapp.presentation.model.MessageModel

/**
MessageStrategy is an interface that provides a contract for setting the elements of a message in a chat message layout.
 */
interface MessageStrategy {
    fun setElements(binding: ChatMessageLayoutItemBinding, item: MessageModel)
}

/**
SenderStrategy, NoInternetStrategy, and ReceiverStrategy are implementations of the MessageStrategy interface,
each providing a specific implementation for setting the elements of a chat message layout based on the type of message.
 */
class SenderStrategy : MessageStrategy {
    override fun setElements(binding: ChatMessageLayoutItemBinding, item: MessageModel) {
        with(binding) {
            with(R.color.purple_100) {
                dateTextView.text = item.sentDate.formatTime()
                dateTextView.setTextBackgroundTint(R.color.gray_200)
                bigDotImageView.setTint(this)
                messageTextView.setBackgroundTint(this)
                smallDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(R.color.black)
            }
            root.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
    }
}

class NoInternetStrategy : MessageStrategy {
    override fun setElements(binding: ChatMessageLayoutItemBinding, item: MessageModel) {
        with(binding) {
            with(R.color.purple_100) {
                dateTextView.text = dateTextView.context.getString(R.string.not_delivered)
                dateTextView.setTextBackgroundTint(android.R.color.holo_red_dark)
                bigDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(this)
                smallDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(R.color.fade)
            }
            root.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
    }
}

class ReceiverStrategy : MessageStrategy {
    override fun setElements(binding: ChatMessageLayoutItemBinding, item: MessageModel) {
        with(binding) {
            with(R.color.gray_100) {
                dateTextView.text = item.sentDate.formatTime()
                dateTextView.setTextBackgroundTint(R.color.gray_200)
                bigDotImageView.setTint(this)
                messageTextView.setBackgroundTint(this)
                smallDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(R.color.black)
            }
            root.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
    }
}
