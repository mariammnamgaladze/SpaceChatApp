package com.space.spacechatapp.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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
        fun bind(adapterListener: () -> String, item: MessageModel) {
            with(binding) {
                messageTextView.text = item.message
                val uiStrategy = if (adapterListener.invoke() == item.user) {
                    if (item.isOnline) SenderStrategy() else NoInternetStrategy()
                } else {
                    ReceiverStrategy()
                }
                uiStrategy.setElements(binding, item)
            }
        }
    }
}


