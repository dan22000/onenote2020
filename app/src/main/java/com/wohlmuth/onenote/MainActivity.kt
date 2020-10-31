package com.wohlmuth.onenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val preferences = Preferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set OnClickListener
        btnLogin.setOnClickListener(this)

        // Animate Icon
        val rotation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        ivIcon.startAnimation(rotation)

        // Don't show MainActivity when user is already logged in
        if (preferences.isUserLoggedIn(this)) {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(v: View?) {
        // Display Toast
        Toast.makeText(this, R.string.logged_in, Toast.LENGTH_LONG).show()

        // Open List Activity
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)

        // Save login state
        preferences.setUserLoggedIn(this, true)

        // Finish MainActivity
        finish()
    }
}