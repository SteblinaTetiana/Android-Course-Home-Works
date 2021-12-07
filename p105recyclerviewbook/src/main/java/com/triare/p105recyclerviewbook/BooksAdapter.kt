package com.triare.p105recyclerviewbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BooksAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }

    inner class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<ImageView>(R.id.icon)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val author = itemView.findViewById<TextView>(R.id.author)

        fun bind(book: Book) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(book.icon)
                .into(icon)
            name.text = book.name
            author.text = book.author
        }
    }
}