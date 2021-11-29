package com.triare.p104recyclerviewfilms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FilmsAdapter(private val films: List<Film>) :
    RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_films, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(films[position])
    }

    override fun getItemCount(): Int {
        return films.size
    }

    inner class FilmsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<ImageView>(R.id.icon)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val year = itemView.findViewById<TextView>(R.id.year)

        fun bind(film: Film) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(film.icon)
                .into(icon)
            name.text = film.name
            year.text = film.year
        }
    }
}