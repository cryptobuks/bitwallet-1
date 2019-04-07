package com.example.bitwallet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Send : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)


        val homeBtn = findViewById<View>(R.id.home) as Button
        homeBtn.setOnClickListener(View.OnClickListener {
                view -> goHome ()
        })

        val sendBtn = findViewById<View>(R.id.send) as Button
        sendBtn.setOnClickListener(View.OnClickListener {
                view -> send ()
        })
    }

    private fun goHome() {
        startActivity(Intent(this, Wallet::class.java))
    }


    private fun send() {
        startActivity(Intent(this, Success::class.java))
    }
}
