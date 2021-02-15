package com.example.janken_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b = 0
        var count1 = "off"
        var wincount = 0
        var count2 = "off"
        var lostCount = 0


        val readFile = File(applicationContext.filesDir, "count1.txt")
        if (readFile.exists()) {
            val contents = readFile.bufferedReader().use(BufferedReader::readText)
            count1 = contents
        }


        var readLost = File(applicationContext.filesDir, "count2.txt")
        if (readLost.exists()) {
            val lostContent = readLost.bufferedReader().use(BufferedReader::readText)
            count2 = lostContent
        }


        var fileee = File(applicationContext.filesDir, "winCount.txt")
        if (fileee.exists()) {
            val contents2 = fileee.bufferedReader().use(BufferedReader::read) //←こいつがreadTextだとエラーが出るっぽい コピペの弊害が......
            wincount = contents2.toInt()
        }

        var fileee2 = File(applicationContext.filesDir, "lostCount.txt")
        if (fileee2.exists()) {
            val contents2 = fileee2.bufferedReader().use(BufferedReader::read)
            lostCount = contents2.toInt()
        }

        var readSeek = File(applicationContext.filesDir, "seekbar.txt")
        if (readSeek.exists()){
            var contents3 = readSeek.bufferedReader().use(BufferedReader::read)
            b = contents3.toInt()
        }




        if (count1 == "on") {
            winText.visibility = View.VISIBLE

        } else {
            winText.visibility = View.INVISIBLE
        }

        if (count2 == "on") {
            lostText.visibility = View.VISIBLE
        } else {
            lostText.visibility = View.INVISIBLE
        }

        if(count1 == "off" && count2 == "off"){
            resetButton.visibility = View.INVISIBLE
        }else{
            resetButton.visibility = View.VISIBLE
        }




        //アプリ起動時に数字を表示させるため
        winText.text = "勝った回数" + wincount.toString() + "回"
        lostText.text = "負けた回数" + lostCount.toString() + "回"

        parcentView.text = b.toString() + "%"
        seekBar.progress = b


        //それぞれ勝ち負けの回数を記録するファイル名
        var fileWin = "winCount.txt"
        var fileLost = "lostCount.txt"
        var fileSeekBar = "seekbar.txt"



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
                File(applicationContext.filesDir, fileSeekBar).writer().use {
                    it.write(b)
                }
            }
        })






        guButton.setOnClickListener() {
            var a = (0..100).random()
            if (a <= b) {
                resultText.text = "勝ち"
                enemyText.text = "チョキ"

                wincount += 1
                winText.text = "勝った回数" + wincount.toString() + "回"
                File(applicationContext.filesDir, fileWin).writer().use {
                    it.write(wincount)


                }

            } else if (a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d) {
                    resultText.text = "アイコ"
                    enemyText.text = "グー"
                } else if (e <= d) {
                    resultText.text = "負け"
                    enemyText.text = "パー"

                    lostCount += 1
                    lostText.text = "負けた回数" + lostCount.toString() + "回"
                    File(applicationContext.filesDir, fileLost).writer().use {
                        it.write(lostCount)
                    }


                }
            }
        }

        paButton.setOnClickListener() {
            var a = (0..100).random()
            if (a <= b) {
                resultText.text = "勝ち"
                enemyText.text = "グー"
                wincount += 1
                winText.text = "勝った回数" + wincount.toString() + "回"
                File(applicationContext.filesDir, fileLost).writer().use {
                    it.write(wincount)
                }

            } else if (a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d) {
                    resultText.text = "アイコ"
                    enemyText.text = "パー"
                } else if (e <= d) {
                    resultText.text = "負け"
                    enemyText.text = "チョキ"

                    lostCount += 1
                    lostText.text = "負けた回数" + lostCount.toString() + "回"
                    File(applicationContext.filesDir, fileLost).writer().use {
                        it.write(lostCount)
                    }


                }
            }
        }

        chokiButton.setOnClickListener() {
            var a = (0..100).random()
            if (a <= b) {
                resultText.text = "勝ち"
                enemyText.text = "パー"

                wincount += 1
                winText.text = "勝った回数" + wincount.toString() + "回"
                File(applicationContext.filesDir, fileWin).writer().use {
                    it.write(wincount)

                }
            } else if (a >= b) {
                var c = 100 - b
                var d = c / 2
                var e = (0..c).random()
                if (e >= d) {
                    resultText.text = "アイコ"
                    enemyText.text = "チョキ"
                } else if (e <= d) {
                    resultText.text = "負け"
                    enemyText.text = "グー"

                    lostCount += 1
                    lostText.text = "負けた回数" + lostCount.toString() + "回"
                    File(applicationContext.filesDir, fileLost).writer().use {
                        it.write(lostCount)
                    }


                }
            }
        }

        setButton.setOnClickListener() {
            val goSecound = Intent(this, secoundActivity::class.java)
            startActivity(goSecound)
        }

        resetButton.setOnClickListener() {
            wincount = 0
            winText.text = "勝った回数" + wincount.toString() + "回"
            File(applicationContext.filesDir, fileWin).writer().use {
                it.write(wincount)


                lostCount = 0
                lostText.text = "負けた回数" + lostCount.toString() + "回"
                File(applicationContext.filesDir, fileLost).writer().use {
                    it.write(lostCount)
                }

            }
        }
    }
}