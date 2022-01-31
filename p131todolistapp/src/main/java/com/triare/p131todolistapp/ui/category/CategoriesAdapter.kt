package com.triare.p131todolistapp.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.model.CategoryDbo

class CategoriesAdapter(var listCategory: List<CategoryDbo>, val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private var title: TextView? = null
    private var date: TextView? = null
   /* private var numberNote: TextView? = null*/

    interface OnItemClickListener {
        fun onClick(category: CategoryDbo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        listCategory[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        init {
            view.setOnClickListener(this)
            initView(view)
        }

        private fun initView(view: View) {
            title = view.findViewById(R.id.title)
            date = view.findViewById(R.id.date)
            /*numberNote = view.findViewById(R.id.number)*/
        }

        fun bind(
            listCategory: CategoryDbo
        ) {
            title?.text = listCategory.title
            date?.text = listCategory.date
            /*numberNote?.text = listCategory.numberNote*/
        }

        override fun onClick(v: View?) {
            clickListener.onClick(listCategory[adapterPosition])
        }
    }
}