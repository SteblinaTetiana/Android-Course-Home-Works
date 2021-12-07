package com.triare.p106recyclerviewuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UsersAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val company = itemView.findViewById<TextView>(R.id.company)

        fun bind(user: User) {
            Glide.with(itemView.context)
                .asBitmap()
                .circleCrop()
                .load(user.avatar)
                .into(avatar)
            name.text = user.name
            company.text = user.company
        }
    }
}