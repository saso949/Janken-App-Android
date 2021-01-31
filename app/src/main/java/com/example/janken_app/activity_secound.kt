package com.example.janken_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_secound.*

class activity_secound : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)
        Log.d("","aaaaaaa")

        countSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                Log.d("",isChecked.toString())

        }


    }
}