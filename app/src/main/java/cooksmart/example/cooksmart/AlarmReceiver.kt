package cooksmart.example.cooksmart

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import com.example.dutyleavemanagmentsystem.R

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.alarm)
        mediaPlayer.start()

    }
}
