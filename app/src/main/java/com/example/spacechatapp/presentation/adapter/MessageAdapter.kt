package com.example.spacechatapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spacechatapp.R
import com.example.spacechatapp.common.extension.setBackgroundTint
import com.example.spacechatapp.common.extension.setTint
import com.example.spacechatapp.databinding.SmsLayoutItemBinding
import com.example.spacechatapp.presentation.model.MessageModel
import com.example.spacechatapp.presentation.model.ChatUser

class MessageAdapter(private val user: ChatUser) :
    ListAdapter<MessageModel, MessageAdapter.MessageViewHolder>(DiffCallback()) {

    inner class MessageViewHolder(val binding: SmsLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = SmsLayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        user.let { user ->
            val message = getItem(position)
            with(holder.binding) {
                smsTV.text = message.message
                dateTV.text = message.sentDate.toString()
                val isSentByTopUser =
                    if (user == ChatUser.TOP_USER) message.isSentByTopUser else !message.isSentByTopUser
                val scale = if (isSentByTopUser) 1f else -1f
                with(scale) {
                    root.scaleX = this
                    smsTV.scaleX = this
                    dateTV.scaleX = this
                }

                val color = if (isSentByTopUser) R.color.purple_100 else R.color.gray_100
                with(ContextCompat.getColor(root.context, color)) {
                    smallDotIV.setTint(this)
                    BigDotIV.setTint(this)
                    smsTV.setBackgroundTint(this)
                }
            }
        }
    }

    class DiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }
}
