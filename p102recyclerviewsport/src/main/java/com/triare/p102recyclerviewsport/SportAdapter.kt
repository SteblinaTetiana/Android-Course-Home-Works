package com.triare.p102recyclerviewsport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SportAdapter(private val sports: List<Sport>) :
    RecyclerView.Adapter<SportAdapter.SportViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        holder.bind(sports[position])
    }

    override fun getItemCount(): Int {
        return sports.size
    }

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<ImageView>(R.id.icon)
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val description = itemView.findViewById<TextView>(R.id.description)

        fun bind(sport: Sport) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(sport.icon)
                .into(icon)
            title.text = sport.title
            description.text = sport.description
        }
    }
}