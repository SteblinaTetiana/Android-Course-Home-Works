package com.triare.p131todolistapp.data.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.triare.p131todolistapp.data.model.CategoryDbo

class CategoryDataSource {

    private val db = Firebase.firestore
    private val categories = db.collection(CATEGORIES_COLLECTION)

    fun addCategory(category: CategoryDbo) {
        val categoryData = HashMap<String, Any>()
        categoryData["title"] = category.title
        categoryData["date"] = category.date
        categories.document().set(categoryData)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    companion object {
        private const val CATEGORIES_COLLECTION = "categories"
    }
}