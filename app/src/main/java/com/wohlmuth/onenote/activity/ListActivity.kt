package com.wohlmuth.onenote.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wohlmuth.onenote.Note
import com.wohlmuth.onenote.NoteAdapter
import com.wohlmuth.onenote.Preferences
import com.wohlmuth.onenote.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), View.OnClickListener {

    private val preferences = Preferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var notes: List<Note> = listOf(
            Note(0,0, "Note 1", "Pizza"),
            Note(0,0, "Note 2", "Pizza"),
            Note(0,0, "Note 3", "Pizza"),
            Note(0,0, "Note 4", "Pizza"),
            Note(0,0, "Note 5", "Pizza"),
            Note(0,0, "Note 6", "Pizza")
        )
        val noteAdapter = NoteAdapter(this, notes)
        lvNotes.adapter = noteAdapter
    }

    override fun onResume() {
        super.onResume()

        updateView()
    }

    private fun updateView() {
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, NoteEditActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add) {
            val intent = Intent(this, NoteEditActivity::class.java)
            startActivity(intent)
        }

        return true
    }
}