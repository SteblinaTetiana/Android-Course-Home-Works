package com.triare.p101recyclerviewchattutorial

data class Chat(
    val id: Int,
    val avatar: String,
    val from: String,
    val message: String,
    val date: String,
    val isRead: Boolean
)