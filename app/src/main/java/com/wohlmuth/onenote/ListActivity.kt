package com.wohlmuth.onenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Added Click Listener
        tvNote.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, NoteEditActivity::class.java)
        startActivity(intent)
    }
}