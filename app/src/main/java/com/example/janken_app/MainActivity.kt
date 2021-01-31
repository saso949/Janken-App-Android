package com.example.janken_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b = 0
        var count = ""
        var wincount = 0

        val readFile = File(applicationContext.filesDir,"count.txt")
        if(readFile.exists()){
            val contents = readFile.bufferedReader().use(BufferedReader::readText)
            count = contents
        }

        if (count == "on"){
            winCount.visibility = View.VISIBLE

        }else{
            winCount.visibility = View.INVISIBLE
        }



        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            // 値が変更された時に呼ばれる
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                parcentView.text = progress.toString() + "%"
                b = progress.toInt()
            }

            // つまみがタッチされた時に呼ばれる
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            // つまみが離された時に呼ばれる
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        guButton.setOnClickListener(){
            var a = (0..100).random()
            if (a <= b){
                resultText.text = "勝ち"
                enemyText.text = "チョキ"
                wincount += 1
                winCount.text = "勝った回数" + wincount.toString() + "回"

            }else if(a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d){
                    resultText.text = "アイコ"
                    enemyText.text = "グー"
                }else if (e <= d){
                    resultText.text = "負け"
                    enemyText.text = "パー"
                }
            }
        }

        paButton.setOnClickListener(){
            var a = (0..100).random()
            if (a <= b){
                resultText.text = "勝ち"
                enemyText.text = "グー"
                wincount += 1
                winCount.text = "勝った回数" + wincount.toString() + "回"
            }else if(a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d){
                    resultText.text = "アイコ"
                    enemyText.text = "パー"
                }else if (e <= d){
                    resultText.text = "負け"
                    enemyText.text = "チョキ"
                }
            }
        }

        chokiButton.setOnClickListener(){
            var a = (0..100).random()
            if (a <= b){
                resultText.text = "勝ち"
                enemyText.text = "パー"
                wincount += 1
                winCount.text = "勝った回数" + wincount.toString() + "回"
            }else if(a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d){
                    resultText.text = "アイコ"
                    enemyText.text = "チョキ"
                }else if (e <= d){
                    resultText.text = "負け"
                    enemyText.text = "グー"
                }
            }
        }

        setButton.setOnClickListener(){
            val goSecound = Intent(this, secoundActivity::class.java)
            startActivity(goSecound)

        }







        }
    }