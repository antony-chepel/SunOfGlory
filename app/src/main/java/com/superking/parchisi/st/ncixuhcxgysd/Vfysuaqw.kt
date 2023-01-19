package com.superking.parchisi.st.ncixuhcxgysd

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.superking.parchisi.st.R
import com.superking.parchisi.st.databinding.ActivityBvyuixzuhsBinding
import kotlin.random.Random

class Vfysuaqw : AppCompatActivity() {
    private var sijdjisda: CountDownTimer? = null
    private var xijcz = 0
    private lateinit var sdasokkoasdo : ActivityBvyuixzuhsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sdasokkoasdo = ActivityBvyuixzuhsBinding.inflate(layoutInflater)
        setContentView(sdasokkoasdo.root)
        rijidsjijfi()

        sdasokkoasdo.aooooxixzji.setOnClickListener {
            xijcz +=1
            sdasokkoasdo.aooooxixzji.visibility = View.GONE
            val bonuxScore = Trusijd.sidjsi[Random.nextInt(8)]
            if(xijcz ==3){
                startActivity(Intent(this,Cdstuxizsdwas::class.java)
                    .putExtra("bonus",bonuxScore)
                )
                finish()
            }
        }
        sdasokkoasdo.odijsjid.setOnClickListener {
            xijcz +=1
            sdasokkoasdo.odijsjid.visibility = View.GONE
            val bonuxScore = Trusijd.sidjsi[Random.nextInt(8)]
            if(xijcz ==3){
                startActivity(Intent(this,Cdstuxizsdwas::class.java)
                    .putExtra("bonus",bonuxScore)
                )
                finish()
            }
        }

        sdasokkoasdo.sijdias.setOnClickListener {
            xijcz +=1
            val sijdjisjia = Trusijd.sidjsi[Random.nextInt(8)]
            sdasokkoasdo.dofj.text = "West points : x$sijdjisjia"
            sdasokkoasdo.sijdias.visibility = View.GONE
            if(xijcz ==3){
                startActivity(Intent(this,Cdstuxizsdwas::class.java)
                    .putExtra("bonus",sijdjisjia)
                )
                finish()
            }
        }



    }


    private fun rijidsjijfi() =with(sdasokkoasdo){
        var sddjisaddwko = 10
        sijdjisda?.cancel()
        sijdjisda = object : CountDownTimer(10000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                sddjisaddwko--
                if(sddjisaddwko >= 0) {
                    val sokdosd = sddjisaddwko.toString()
                    coxvjixc.text = "Time : $sokdosd sec"

                    when(sddjisaddwko){
                        3-> coxvjixc.setTextColor(resources.getColor(R.color.clr_sun_time))
                        2-> coxvjixc.setTextColor(resources.getColor(R.color.clr_sun_time))
                        1-> coxvjixc.setTextColor(resources.getColor(R.color.clr_sun_time))
                        0-> coxvjixc.setTextColor(resources.getColor(R.color.clr_sun_time))
                    }
                }
            }

            override fun onFinish() {
                coxvjixc.setTextColor(resources.getColor(R.color.white))
                if(sddjisaddwko==0){
                    sddjisaddwko = 10
                    startActivity(
                        Intent(this@Vfysuaqw,Cdstuxizsdwas::class.java)
                    )
                    finish()
                }


            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        sijdjisda?.cancel()
    }
}