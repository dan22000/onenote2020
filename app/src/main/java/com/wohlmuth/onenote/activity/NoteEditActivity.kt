package com.wohlmuth.onenote.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.wohlmuth.onenote.Database
import com.wohlmuth.onenote.Note
import com.wohlmuth.onenote.R
import kotlinx.android.synthetic.main.activity_note_edit.*

class NoteEditActivity : AppCompatActivity(), View.OnClickListener, DialogInterface.OnClickListener {

    private val db = Database(this)
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_edit)
        btnSave.setOnClickListener(this)

        val id = intent.getLongExtra("id", 0)
        note = db.getNote(id)
        etTitle.setText(note?.title)
        etMessage.setText(note?.message)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note_edit, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            AlertDialog.Builder(this)
                .setMessage(R.string.delete_message)
                .setPositiveButton(R.string.yes, this)
                .setNegativeButton(R.string.no, null)
                .show()
        } else if (item.itemId == android.R.id.home) {
            finish()
        }

        return true
    }

    private fun saveNote() {
        val title = etTitle.text.toString()
        val message = etMessage.text.toString()
        val db = Database(this)
        db.insertNote(Note(0, System.currentTimeMillis(), title, message))

        Toast.makeText(this, R.string.note_saved, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onClick(v: View?) {
        saveNote()
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        saveNote()
        finish()
    }
}