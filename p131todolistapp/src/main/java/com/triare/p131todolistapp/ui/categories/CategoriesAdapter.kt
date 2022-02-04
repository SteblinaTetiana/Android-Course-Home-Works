package com.triare.p131todolistapp.ui.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.model.CategoryDbo

class CategoriesAdapter(
    val clickListener: OnItemClickListener
) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    var listCategories: List<CategoryDbo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface OnItemClickListener {
        fun onClick(category: CategoryDbo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        listCategories[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    inner class CategoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(
            listCategory: CategoryDbo
        ) {
            view.findViewById<TextView>(R.id.title).text = listCategory.title
            view.findViewById<TextView>(R.id.date).text = listCategory.date
            view.setOnClickListener {
                clickListener.onClick(listCategory)
            }
            /*numberNote?.text = listCategory.numberNote*/
        }
    }
}