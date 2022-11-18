package com.playgendary.sportmasterss

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*

class GoodLikeManClass: Application() {
    companion object {
//        var prteresult = ""
//        var prteresultLinkSasha = ""

        const val dfwthyhyj = "43341098911299610355"
        const val jglfkdkdkgjd = "5d497a48-8705-492c-bbb2-dd703d7fdd9f"

        // add for easy
//        const val apps_code = ""
//        const val BASE_URL = ""
//        const val BASE_URL_GEO_API = ""
//        val PACK = ""

        var appsCheck = "appsChecker"
        var C1: String? = "c11"
        var myID: String? = "myID"
        var instId: String? = "instID"
        var link = "link"
        var MAIN_ID: String? = ""
    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(jglfkdkdkgjd)

        Hawk.init(this).build()


        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true
        if (settings.getBoolean("my_first_time", true)) {
            val IDIN = UUID.randomUUID().toString()
            trackerParams.setCustomUserId(IDIN)
            Hawk.put(myID, IDIN)
            Hawk.put(instId, instID)
            settings.edit().putBoolean("my_first_time", false).apply()

        } else {
            val IDIN = Hawk.get(myID, "null")
            trackerParams.setCustomUserId(IDIN)
        }
        MyTracker.initTracker(dfwthyhyj, this)

    }


}
