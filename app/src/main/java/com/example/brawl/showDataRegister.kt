package com.example.brawl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class showDataRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_register)

        supportActionBar!!.setTitle("Show Data")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val fname = intent.getStringExtra("F_name")
        val lname = intent.getStringExtra("L_name")
        val email = intent.getStringExtra("Email")
        val password = intent.getStringExtra("Password")
        val repeat = intent.getStringExtra("R_password")

        val result = findViewById<TextView>(R.id.resultregister)
        result.text = "Name:\n\t\t\b"+fname + " " + lname +
                "\n\nEmail:\n\t\t\n" + email +
                "\n\npassword:\n\t\t\b"+password
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}