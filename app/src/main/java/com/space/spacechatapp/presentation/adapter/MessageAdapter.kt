package com.space.spacechatapp.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.spacechatapp.common.extension.viewBinding
import com.space.spacechatapp.databinding.ChatMessageLayoutItemBinding
import com.space.spacechatapp.presentation.model.MessageModel

/**
 * The MessageAdapter class is a custom adapter used to display a list of messages in a RecyclerView.
 * It extends the ListAdapter abstract class, which provides a base implementation for an adapter that can efficiently calculate differences between two lists of data.
 */
class MessageAdapter(private val adapterListener: AdapterListener) :
    ListAdapter<MessageModel, MessageAdapter.MessageViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(parent.viewBinding(ChatMessageLayoutItemBinding::inflate))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(adapterListener, getItem(position))
    }

    class MessageViewHolder(private val binding: ChatMessageLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(adapterListener: AdapterListener, item: MessageModel) {
            with(binding) {
                messageTextView.text = item.message
                val uiStrategy = if (adapterListener.getUserId() == item.user) {
                    if (item.isOnline) SenderStrategy() else NoInternetStrategy()
                } else {
                    ReceiverStrategy()
                }
                uiStrategy.setElements(binding, item)
            }
        }
    }
}


