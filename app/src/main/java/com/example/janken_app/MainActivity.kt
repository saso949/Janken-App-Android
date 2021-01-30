package com.example.janken_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b = 0


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
            }else if(a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d){
                    resultText.text = "アイコ"
                }else if (e <= d){
                    resultText.text = "負け"
                }
            }
        }

        paButton.setOnClickListener(){
            var a = (0..100).random()
            if (a <= b){
                resultText.text = "勝ち"
            }else if(a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d){
                    resultText.text = "アイコ"
                }else if (e <= d){
                    resultText.text = "負け"
                }
            }
        }

        chokiButton.setOnClickListener(){
            var a = (0..100).random()
            if (a <= b){
                resultText.text = "勝ち"
            }else if(a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d){
                    resultText.text = "アイコ"
                }else if (e <= d){
                    resultText.text = "負け"
                }
            }
        }

        }

    }