package com.wohlmuth.onenote

data class Note(val id: Long, val timestamp: Long, var title: String, var message: String, val latitude: Double, val longitude: Double)