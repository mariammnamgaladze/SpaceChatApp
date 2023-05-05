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

class MessageAdapter(private val adapterListener: () -> String) :
    ListAdapter<MessageModel, MessageAdapter.MessageViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(parent.viewBinding(ChatMessageLayoutItemBinding::inflate))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(adapterListener, getItem(position))
    }

    class MessageViewHolder(private val binding: ChatMessageLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(adapterListener: () -> kotlin.String, message: MessageModel) {
            with(binding) {
                messageTextView.text = message.message
                dateTextView.text = message.sentDate.formatTime()
                root.layoutDirection =
                    if (adapterListener.invoke() == message.user) View.LAYOUT_DIRECTION_LTR else View.LAYOUT_DIRECTION_RTL
                messageTextView.layoutDirection
                dateTextView.layoutDirection
                val colorResId =
                    if (adapterListener.invoke() == message.user) R.color.purple_100 else R.color.gray_100
                with(colorResId) {
                    smallDotImageView.setTint(this)
                    bigDotImageView.setTint(this)
                    messageTextView.setBackgroundTint(this)
                }
            }
        }
    }
}

