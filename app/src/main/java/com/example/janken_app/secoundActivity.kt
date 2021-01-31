package com.example.janken_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_secound.*

class secoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)
        countSwitch.setOnCheckedChangeListener(){buttonView, isChecked ->
            //switchがONになったのを検出
            if (isChecked.toString() == "true"){
                Log.d("aaaa","a;sdfkja;")
                //switchがoffになったのを検出
            }else if(isChecked.toString() == "fasle"){

            }
        }

    }
}