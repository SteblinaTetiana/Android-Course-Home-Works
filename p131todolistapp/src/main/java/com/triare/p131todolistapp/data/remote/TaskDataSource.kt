package com.triare.p131todolistapp.data.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.triare.p131todolistapp.data.model.TaskDbo

class TaskDataSource {

    private val db = Firebase.firestore
    private val tasks = db.collection(TASKS_COLLECTION)

    fun addTask(task: TaskDbo) {
        val taskData = HashMap<String, Any>()
        taskData["text"] = task.text
        taskData["isFinished"] = task.isFinished
        tasks.add(taskData)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    companion object {
        private const val TASKS_COLLECTION = "tasks"
    }
}