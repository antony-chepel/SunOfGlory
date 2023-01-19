package com.superking.parchisi.st.bxzuhzhuxsaw


import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.applinks.AppLinkData
import com.superking.parchisi.st.Qosisuahas
import kotlinx.coroutines.launch

class Mxoxzijjsa : ViewModel() {

val isdjasdj : MutableLiveData<Njsiusha> = MutableLiveData()
    val suhdhusahu : MutableLiveData<Giosaijwq> = MutableLiveData()


        fun zpzokxkozkoaji(){
            viewModelScope.launch {
                isdjasdj.value = Soaisdjudhw.sijisdjiaj()

            }
    }

    fun forijdsok(oxoxoxxichuuhc: Context) {
        val ksioaidshuhuads = oxoxoxxichuuhc.getSharedPreferences(Qosisuahas.deeps,Application.MODE_PRIVATE)
        AppLinkData.fetchDeferredAppLinkData(
            oxoxoxxichuuhc
        ) { mkxozijc: AppLinkData? ->
            mkxozijc?.let {
                val params = mkxozijc.targetUri.host.toString()
                ksioaidshuhuads.edit().putString(Qosisuahas.deeps,params).apply()
            }
            if (mkxozijc == null) {
            }
        }
    }

    fun eosjiiasjid(){
        viewModelScope.launch {
            suhdhusahu.value = Soaisdjudhw.oxicjixz()

        }
    }







}