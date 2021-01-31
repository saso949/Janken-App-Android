package com.example.janken_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_secound.*
import java.io.BufferedReader
import java.io.File
import java.util.function.LongFunction

class secoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)

        var count = ""
        val readFile = File(applicationContext.filesDir,"count.txt")
        if(readFile.exists()){
            count = readFile.bufferedReader().use(BufferedReader::readText)
        }

        if (count == "on"){
            countSwitch.isChecked = true
            Log.d("","a;sdkfj")
        }else if(count == "off"){
            Log.d("","あjsd；fkじゃs")
            countSwitch.isChecked = false
        }




        countSwitch.setOnCheckedChangeListener(){buttonView, isChecked ->

            //switchがONになったのを検出
            if (isChecked.toString() == "true"){
                Log.d("aaaa","a;sdfkja;")
                count = "on"
                //switchがoffになったのを検出
            }else if(isChecked.toString() == "false"){
                count = "off"
                Log.d("a;sdfk","ほほい")
            }
        }



        backButton.setOnClickListener(){
            val goMain = Intent(this, MainActivity::class.java)
            startActivity(goMain)

            val fileName = "count.txt"
            val str = count
            File(applicationContext.filesDir, fileName).writer().use {
                it.write(str)
            }
        }





    }
}