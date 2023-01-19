package com.superking.parchisi.st

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import java.util.*

class Qosisuahas : Application() {
    companion object {
        var namings: String? = "c11"
        var main_id: String? = "main_id"
        var link = "link"
        val myid: String = "myID"

        var apps = "appsChecker"
        const val ozkxizj = "6e794d5f-c129-463d-9e0c-ab3a991d66d0"

        var deeps: String? = "d11"
        var instId: String? = "instID"
        val appsID = "NzbdkfSWzoa9FRzfMaw3ia"





    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ozkxizj)




        val dokfs = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val apapaslplaspoksa = getSharedPreferences("PREFS_NAME", 0)

        val xijczji = MyTracker.getTrackerParams()
        val sodkoskod = MyTracker.getTrackerConfig()
        val sijdisdjsdji = MyTracker.getInstanceId(this)
        sodkoskod.isTrackingLaunchEnabled = true
        val mxcxckxc = UUID.randomUUID().toString()

        if (apapaslplaspoksa.getBoolean("my_first_time", true)) {
            xijczji.setCustomUserId(mxcxckxc)
            dokfs.edit().putString(myid, mxcxckxc).apply()
            dokfs.edit().putString(instId, sijdisdjsdji).apply()
            apapaslplaspoksa.edit().putBoolean("my_first_time", false).apply()
        } else {
            val aoksosa = dokfs.getString(myid, mxcxckxc)
            xijczji.setCustomUserId(aoksosa)
        }
        MyTracker.initTracker("27196006048890395932", this)
    }
}