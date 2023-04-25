package com.example.spacechatapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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

                val scale = if (user.name == message.user.name) SCALE_POSITIVE else SCALE_NEGATIVE
                with(scale) {
                    root.scaleX = this
                    messageTextView.scaleX = this
                    dateTextView.scaleX = this
                }
                val colorResId =
                    if (user.name == message.user.name) COLOR_SEND else COLOR_RECEIVE
                with(colorResId) {
                    smallDotImageView.setTint(this)
                    bigDotImageView.setTint(this)
                    messageTextView.setBackgroundTint(this)
                }
            }
        }

        companion object {
            const val COLOR_SEND = R.color.purple_100
            const val COLOR_RECEIVE = R.color.gray_100
            const val SCALE_POSITIVE = 1f
            const val SCALE_NEGATIVE= -1f

        }
    }
}

