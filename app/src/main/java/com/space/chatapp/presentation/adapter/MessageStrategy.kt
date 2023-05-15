package com.space.chatapp.presentation.adapter

import android.view.View
import com.space.chatapp.R
import com.space.chatapp.common.extension.*
import com.space.chatapp.databinding.ChatMessageLayoutItemBinding
import com.space.chatapp.presentation.model.MessageModel

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
            with(R.color.purple_light) {
                dateTextView.text = item.sentDate.formatTime()
                dateTextView.setTextBackgroundTint(R.color.neutral_03_grey)
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
            with(R.color.purple_light) {
                dateTextView.text = dateTextView.context.getString(R.string.not_delivered)
                dateTextView.setTextBackgroundTint(R.color.error_label)
                bigDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(this)
                smallDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(R.color.error_text)
            }
            root.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
    }
}

class ReceiverStrategy : MessageStrategy {
    override fun setElements(binding: ChatMessageLayoutItemBinding, item: MessageModel) {
        with(binding) {
            with(R.color.neutral_05_lightest_grey) {
                dateTextView.text = item.sentDate.formatTime()
                dateTextView.setTextBackgroundTint(R.color.neutral_03_grey)
                bigDotImageView.setTint(this)
                messageTextView.setBackgroundTint(this)
                smallDotImageView.setTint(this)
                messageTextView.setTextBackgroundTint(R.color.black)
            }
            root.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
    }
}
