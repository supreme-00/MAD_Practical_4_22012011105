package com.example.mad_practical_4_22012011105

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.ContactsContract.CommonDataKinds.Note
class AlarmBroadcastReceiver : BroadcastReceiver() {
    var mp: MediaPlayer? = null
    override fun onReceive(context: Context?, intent: Intent?) {
        var note:Note? = null
        if(intent!=null){
            mp = MediaPlayer.create(context,R.raw.alarm)
            mp?.start()
        }
        if(intent != null && context!=null){
            val str1 = intent.getStringExtra("Service1")
            if(str1 == null){}
            else if(str1 == "Start" || str1 == "Stop"){
                val intentService = Intent(context, AlarmService::class.java)
                intentService.putExtra("Service1", intent.getStringExtra("Service1"))
                if(str1 == "Start"){
                    context.startService(intentService)
                }
                else if(str1 == "Stop"){
                    context.stopService(intentService)
                }
            }
        }
    }
}