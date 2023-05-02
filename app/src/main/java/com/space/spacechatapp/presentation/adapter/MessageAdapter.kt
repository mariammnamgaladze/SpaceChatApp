package com.space.spacechatapp.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.spacechatapp.R
import com.space.spacechatapp.common.extension.formatTime
import com.space.spacechatapp.common.extension.setBackgroundTint
import com.space.spacechatapp.common.extension.setTint
import com.space.spacechatapp.common.extension.viewBinding
import com.space.spacechatapp.databinding.ChatMessageLayoutItemBinding
import com.space.spacechatapp.presentation.model.MessageModel
import com.space.spacechatapp.presentation.model.ChatUser

class MessageAdapter(private val user: ChatUser) :
    ListAdapter<MessageModel, MessageAdapter.MessageViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(parent.viewBinding(ChatMessageLayoutItemBinding::inflate))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(user, getItem(position))
    }

    class MessageViewHolder(val binding: ChatMessageLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: ChatUser, message: MessageModel) {
            with(binding) {
                messageTextView.text = message.message
                dateTextView.text = message.sentDate.formatTime()
                root.layoutDirection =
                    if (user.name == message.user.name) View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
                messageTextView.layoutDirection
                dateTextView.layoutDirection
                val colorResId =
                    if (user.name == message.user.name) R.color.purple_100 else R.color.gray_100
                with(colorResId) {
                    smallDotImageView.setTint(this)
                    bigDotImageView.setTint(this)
                    messageTextView.setBackgroundTint(this)
                }
            }
        }
    }
}

