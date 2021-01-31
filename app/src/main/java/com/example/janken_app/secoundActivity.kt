package com.example.janken_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_secound.*

class secoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)

        var count = intent.getStringExtra("ch")


        countSwitch.setOnCheckedChangeListener(){buttonView, isChecked ->

            //switchがONになったのを検出
            if (isChecked.toString() == "true"){
                Log.d("aaaa","a;sdfkja;")
                count = "on"
                //switchがoffになったのを検出
            }else if(isChecked.toString() == "fasle"){
                count = "off"

            }
        }



        backButton.setOnClickListener(){
            val goMain = Intent(this, MainActivity::class.java)
            goMain.putExtra("ch",count)
            startActivity(goMain)
        }





    }
}