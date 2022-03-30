package com.example.a51900035_51900087_51900593

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOne.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "1") }
        tvTwo.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "2") }
        tvThree.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "3") }
        tvFour.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "4") }
        tvFive.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "5") }
        tvSix.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "6") }
        tvSeven.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "7") }
        tvEight.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "8") }
        tvNine.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "9") }
        tvZero.setOnClickListener { tvSpace.text = (tvSpace.text.toString() + "0") }
        tvPlus.setOnClickListener {
            if (tvResult.text.toString().isNotEmpty()) {
                tvSpace.text = (tvResult.text.toString() + "+")
            } else {
                tvSpace.text = (tvSpace.text.toString() + "+")
            }
            tvResult.text = ""
        }
        tvSub.setOnClickListener {
            if (tvResult.text.toString().isNotEmpty()) {
                tvSpace.text = (tvResult.text.toString() + "-")
            } else {
                tvSpace.text = (tvSpace.text.toString() + "-")
            }
            tvResult.text = ""
        }
        tvMulti.setOnClickListener {
            if (tvResult.text.toString().isNotEmpty()) {
                tvSpace.text = (tvResult.text.toString() + "*")
            } else {
                tvSpace.text = (tvSpace.text.toString() + "*")
            }
            tvResult.text = ""
        }
        tvDivide.setOnClickListener {
            if (tvResult.text.toString().isNotEmpty()) {
                tvSpace.text = (tvResult.text.toString() + "/")
            } else {
                tvSpace.text = (tvSpace.text.toString() + "/")
            }
            tvResult.text = ""

        }
        tvDot.setOnClickListener {
            if (tvResult.text.toString().isNotEmpty()) {
                tvSpace.text = (tvResult.text.toString() + ".")
            } else {
                tvSpace.text = (tvSpace.text.toString() + ".")
            }
            tvResult.text = ""
        }

        tvClear.setOnClickListener {
            tvSpace.text = ""
            tvResult.text = ""
        }

        tvPercent.setOnClickListener {
            try {
                if (tvResult.toString().isNotEmpty())
                {
                    var s = tvResult.text.toString()
                    var d = s.toDouble() / 100.0
                    tvResult.text = d.toString()
                    tvSpace.text = ""
                }

                else{
                    var s = tvSpace.text.toString()
                    var d = s.toDouble() / 100.0
                    tvResult.text = d.toString()
                    tvSpace.text = ""
                }
        }
        catch(e:Exception){
            tvSpace.text = ""
            tvResult.text = "Error"
        }
    }


        ibDelete.setOnClickListener {
            val s = tvSpace.text.toString()
            if (s.isNotEmpty()){
                tvSpace.text = s.substring(0,s.length-1)
            }
        }

        tvEqual.setOnClickListener {
            try {
                val s = ExpressionBuilder(tvSpace.text.toString()).build()
                val result = s.evaluate()
                val resultInt = result.toInt()
                var num:Double = String.format("%.3f",result).toDouble()

                if (result == resultInt.toDouble()) {
                    tvResult.text = resultInt.toString()
                }

                else
                    tvResult.text = num.toString()
            }

            catch (e:Exception){
                tvSpace.text = ""
                tvResult.text = "Error"
            }



        }


    }
}