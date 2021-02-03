package com.example.janken_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_secound.*
import java.io.BufferedReader
import java.io.File

class secoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)

        var count1 = ""
        var count2 = ""


        val readFile = File(applicationContext.filesDir, "count1.txt")
        if (readFile.exists()) {
            count1 = readFile.bufferedReader().use(BufferedReader::readText)
        }

        var readLost = File(applicationContext.filesDir, "count2.txt")
        if (readLost.exists()) {
            val lostContent = readLost.bufferedReader().use(BufferedReader::readText)
            count2 = lostContent
        }

        if (count1 == "on") {
            countSwitch.isChecked = true
            Log.d("", "a;sdkfj")
        } else if (count1 == "off") {
            Log.d("", "あjsd；fkじゃs")
            countSwitch.isChecked = false
        }

        if (count2 == "on") {
            lostSwitch.isChecked = true
        } else if (count2 == "off") {
            lostSwitch.isChecked = false
        }





        countSwitch.setOnCheckedChangeListener() { buttonView, isChecked ->

            //switchがONになったのを検出
            if (isChecked.toString() == "true") {
                Log.d("aaaa", "a;sdfkja;")
                count1 = "on"
                //switchがoffになったのを検出
            } else if (isChecked.toString() == "false") {
                count1 = "off"
                Log.d("a;sdfk", "ほほい")
            }
        }

        lostSwitch.setOnCheckedChangeListener() { buttonView, isChecked ->
            if (isChecked.toString() == "true") {
                count2 = "on"
            } else if (isChecked.toString() == "false") {
                count2 = "off"
            }
        }



        backButton.setOnClickListener() {
            val goMain = Intent(this, MainActivity::class.java)
            startActivity(goMain)

            val winFile = "count1.txt"
            val str = count1
            File(applicationContext.filesDir, winFile).writer().use {
                it.write(str)


                var lostFile = "count2.txt"
                File(applicationContext.filesDir, lostFile).writer().use {
                    it.write(count2)

                }
            }


        }
    }
}
