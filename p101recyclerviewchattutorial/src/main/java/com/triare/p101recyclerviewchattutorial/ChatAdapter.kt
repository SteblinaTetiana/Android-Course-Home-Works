package com.triare.p101recyclerviewchattutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatAdapter(private val chats: List<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        private val from = itemView.findViewById<TextView>(R.id.from)
        private val message = itemView.findViewById<TextView>(R.id.message)
        private val date = itemView.findViewById<TextView>(R.id.date)


        fun bind(chat: Chat) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(chat.avatar)
                .circleCrop()
                .into(avatar)

            from.text = chat.from
            message.text = chat.message
            date.text = chat.date

            val isReadIcon = if (chat.isRead) {
                R.drawable.ic_read
            } else {
                R.drawable.ic_unread
            }
            date.setCompoundDrawablesWithIntrinsicBounds(isReadIcon, 0, 0, 0)
        }
    }
}