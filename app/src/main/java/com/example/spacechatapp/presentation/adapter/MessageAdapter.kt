package com.example.spacechatapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spacechatapp.R
import com.example.spacechatapp.common.extension.setBackgroundTint
import com.example.spacechatapp.common.extension.setTint
import com.example.spacechatapp.databinding.ChatMessageLayoutItemBinding
import com.example.spacechatapp.presentation.model.MessageModel
import com.example.spacechatapp.presentation.model.ChatUser

class MessageAdapter(private val user: ChatUser) :
    ListAdapter<MessageModel, MessageAdapter.MessageViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ChatMessageLayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(user, getItem(position))
    }

    class MessageViewHolder(private val binding: ChatMessageLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: ChatUser, message: MessageModel) {
            with(binding) {
                messageTextView.text = message.message
                dateTextView.text = message.sentDate.toString()
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

