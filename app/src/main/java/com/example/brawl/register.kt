package com.example.brawl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.setTitle("Register Now")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val firstname = findViewById<EditText>(R.id.etfirstname)
        val lastname = findViewById<EditText>(R.id.etlastname)
        val email = findViewById<EditText>(R.id.etemail)
        val pasword = findViewById<EditText>(R.id.etpassword)
        val repeat = findViewById<EditText>(R.id.etrepeat)
        val signup = findViewById<Button>(R.id.btnsign)

        signup.setOnClickListener {
            if (firstname.text.toString() == "") {
                Toast.makeText(
                    this ,
                    "First Name Tidak Boleh Kosong" ,
                    Toast.LENGTH_SHORT).show()
                firstname.setSelection(0)
                true
            }
            else if (lastname.text.toString() == "") {
                Toast.makeText(
                    this ,
                    "Last Name Tidak Boleh Kosong" ,
                    Toast.LENGTH_SHORT).show()
                lastname.setSelection(0)
                true
            }
            else if (email.text.toString() == "") {
                Toast.makeText(
                    this ,
                    "Email Tidak Boleh Kosong" ,
                    Toast.LENGTH_SHORT).show()
                email.setSelection(0)
                true
            }

            else if (repeat.text.toString() == "") {
                Toast.makeText(
                    this ,
                    "Ikuti Sesuai Password Anda" ,
                    Toast.LENGTH_SHORT).show()
                repeat.setSelection(0)
                true
            }

            else if (pasword.text.toString() != repeat.text.toString()) {
                Toast.makeText(
                    this,
                    "Repeat Password harus sama dengan password",
                    Toast.LENGTH_SHORT
                ).show()
                pasword.setSelection(0)
                true
            }

            else if (repeat.text.toString() == "") {
                Toast.makeText(
                    this ,
                    "Isi Password Anda" ,
                    Toast.LENGTH_SHORT).show()
                repeat.setSelection(0)
                true
            }
            else {

                val get_f_name = firstname.text.toString()
                val get_l_name = lastname.text.toString()
                val getemail = email.text.toString()
                val getpassword = pasword.text.toString()
                val getrepeat = repeat.text.toString()

                val intent = Intent(applicationContext ,
                showDataRegister::class.java)
                intent.putExtra("F_name" , get_f_name)
                intent.putExtra("L_name" , get_l_name)
                intent.putExtra("Email" , getemail)
                intent.putExtra("Password" , getpassword)
                intent.putExtra("R_password" , getrepeat)
                startActivity(intent)

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true


    }
}