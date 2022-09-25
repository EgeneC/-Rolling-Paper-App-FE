package com.example.hwae_word4you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.hwae_word4you.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val dialogBtn: Button = findViewById(R.id.dialog_btn)
        dialogBtn.setOnClickListener{

        showDialog()
        }
    }

    private fun showDialog(){

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setTitle("로그인")

        val inflater: LayoutInflater = layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_dialog, null))

            builder.setPositiveButton("OK") { p0, p1 ->
            }

            builder.setNegativeButton("CANCEL"){
                dialog, p1 -> dialog.cancel()
            }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}