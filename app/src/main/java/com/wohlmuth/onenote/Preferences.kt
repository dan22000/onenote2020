package com.wohlmuth.onenote

import android.content.Context

class Preferences {

    private val PREFERENCES_USER_LOGGED_IN = "user_logged_in"
    private val PREFERENCES_NOTE_TITLE = "note_title"
    private val PREFERENCES_NOTE_MESSAGE = "note_message"
    private val PREFERENCES_NAME = "preferences_note"

    fun isUserLoggedIn(context: Context): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        return preferences.getBoolean(PREFERENCES_USER_LOGGED_IN, false)
    }

    fun setUserLoggedIn(context: Context, loggedIn: Boolean) {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        preferences.edit().putBoolean(PREFERENCES_USER_LOGGED_IN, loggedIn).apply()
    }

    fun setNoteTitle(context: Context, title: String) {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        preferences.edit().putString(PREFERENCES_NOTE_TITLE, title).apply()
    }

    fun getNoteTitle(context: Context): String? {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        return preferences.getString(PREFERENCES_NOTE_TITLE, null)
    }

    fun setNoteMessage(context: Context, message: String) {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        preferences.edit().putString(PREFERENCES_NOTE_MESSAGE, message).apply()
    }

    fun getNoteMessage(context: Context): String? {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        return preferences.getString(PREFERENCES_NOTE_MESSAGE, null)
    }
}