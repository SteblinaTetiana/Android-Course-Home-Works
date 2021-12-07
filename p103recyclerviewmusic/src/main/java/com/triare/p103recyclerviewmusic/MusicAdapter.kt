package com.triare.p103recyclerviewmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(private val musics: List<Music>) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musics[position])
    }

    override fun getItemCount(): Int {
        return musics.size
    }

    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<ImageView>(R.id.icon)
        private val song = itemView.findViewById<TextView>(R.id.song)
        private val singer = itemView.findViewById<TextView>(R.id.singer)

        fun bind(music: Music) {
            song.text = music.song
            singer.text = music.singer
        }
    }
}