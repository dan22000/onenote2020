package com.wohlmuth.onenote

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), View.OnClickListener {

    private val preferences = Preferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val values = arrayOf(
            "Pizza",
            "Ice Cream",
            "Cola",
            "Pizza",
            "Ice Cream",
            "Cola",
            "Pizza",
            "Ice Cream",
            "Cola",
            "Pizza",
            "Ice Cream",
            "Cola",
            "Pizza",
            "Ice Cream",
            "Cola",
            "Pizza",
            "Ice Cream",
            "Cola",
            "Pizza",
            "Ice Cream",
            "Cola"
        )

        val myAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values)
        lvNotes.adapter = myAdapter
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