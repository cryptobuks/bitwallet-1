package com.example.bitwallet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_wallet.*

class Wallet : Activity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        mDatabase = FirebaseDatabase.getInstance().getReference("Users")

        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                System.out.println("The read failed: ")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                System.out.println("Data changed: ")
            }

        })

        val signOut = findViewById<View>(R.id.signOut) as Button
        signOut.setOnClickListener(View.OnClickListener {
                view -> signOut()
        })

        val receiveLayout = findViewById<View>(R.id.Receive) as ConstraintLayout
        val sendLayout = findViewById<View>(R.id.Send) as ConstraintLayout
        val transLayout = findViewById<View>(R.id.Transactions) as ConstraintLayout
        val infoLayout = findViewById<View>(R.id.Info) as ConstraintLayout
        receiveLayout.setOnClickListener(View.OnClickListener {
                view -> goReceive ()
        })
        sendLayout.setOnClickListener(View.OnClickListener {
                view -> goSend ()
        })
        transLayout.setOnClickListener(View.OnClickListener {
                view -> goTransactions ()
        })
        infoLayout.setOnClickListener(View.OnClickListener {
                view -> goInfo ()
        })

    }

    private fun signOut(){
        mAuth.signOut()
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this, "Logged out :(", Toast.LENGTH_LONG).show()
    }

    private fun goReceive() {
        startActivity(Intent(this, Receive::class.java))
    }

    private fun goSend() {
        startActivity(Intent(this, Send::class.java))
    }

    private fun goTransactions() {
        startActivity(Intent(this, Transactions::class.java))
    }

    private fun goInfo() {
        startActivity(Intent(this, Info::class.java))
    }

}