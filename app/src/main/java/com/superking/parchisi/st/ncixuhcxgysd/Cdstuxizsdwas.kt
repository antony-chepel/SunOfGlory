package com.superking.parchisi.st.ncixuhcxgysd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.superking.parchisi.st.databinding.ActivityCdstuxizsdwasBinding

class Cdstuxizsdwas : AppCompatActivity() {
    private lateinit var mxkcjixc : ActivityCdstuxizsdwasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mxkcjixc = ActivityCdstuxizsdwasBinding.inflate(layoutInflater)
        setContentView(mxkcjixc.root)
        val winBonus = intent.getIntExtra("bonus",0)
        val alwsWin = 500
        val totalwin = alwsWin * winBonus
        mxkcjixc.sijdjsi.text = "Received $winBonus bonuses"
        mxkcjixc.iocvj.text = "You got $totalwin golden points "
        mxkcjixc.aosjiaias.setOnClickListener {
            startActivity(Intent(this,Vfysuaqw::class.java))
        }

    }
}