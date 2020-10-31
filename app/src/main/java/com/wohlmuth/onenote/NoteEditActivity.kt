package com.wohlmuth.onenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note_edit.*

class NoteEditActivity : AppCompatActivity(), View.OnClickListener {

    private val preferences = Preferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_edit)
        btnSave.setOnClickListener(this)

        etTitle.setText(preferences.getNoteTitle(this))
        etMessage.setText(preferences.getNoteMessage(this))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note_edit, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            preferences.setNoteTitle(this, null)
            preferences.setNoteMessage(this, null)
            finish()
        }

        return true
    }

    private fun saveNote() {
        preferences.setNoteTitle(this, etTitle.text.toString())
        preferences.setNoteMessage(this, etMessage.text.toString())
        Toast.makeText(this, R.string.note_saved, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onClick(v: View?) {
        saveNote()
    }
}