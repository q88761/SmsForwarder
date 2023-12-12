package com.idormy.sms.forwarder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.idormy.sms.forwarder.activity.SplashActivity

@Suppress("PropertyName")
class BootCompletedReceiver : BroadcastReceiver() {

    val TAG: String = BootCompletedReceiver::class.java.simpleName

    override fun onReceive(context: Context, intent: Intent?) {

        if (intent?.action != Intent.ACTION_BOOT_COMPLETED && intent?.action != Intent.ACTION_LOCKED_BOOT_COMPLETED) return

        try {
            Log.d(TAG, "强制重启APP一次")
            val intent1 = Intent(context, SplashActivity::class.java)
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent1)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}