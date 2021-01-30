package com.example.janken_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // 値が変更された時に呼ばれる
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                parcentView.text = progress.toString() + "%"
            }
        })

    }
}