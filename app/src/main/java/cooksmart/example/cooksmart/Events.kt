package cooksmart.example.cooksmart

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import com.example.dutyleavemanagmentsystem.R
import org.json.JSONObject


class Events : Fragment() {
    lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {

        v = inflater.inflate(R.layout.fragment_events,container,false)

        var btn1=v.findViewById<Button>(R.id.btnRegister1)
        var btn2 = v.findViewById<Button>(R.id.btnRegister2)
        var btn3 = v.findViewById<Button>(R.id.btnRegister3)
        var btn4 = v.findViewById<Button>(R.id.btnRegister4)

        btn1.setOnClickListener {
            onRegisterButtonClick(btn1)
        }

        btn2.setOnClickListener {
            onRegisterButtonClick(btn2)
        }

        btn3.setOnClickListener {
            onRegisterButtonClick(btn3)
        }

        btn4.setOnClickListener {
            onRegisterButtonClick(btn4)
        }
        return  v
    }
    fun onRegisterButtonClick(button:Button) {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Do you want to register this event?")
        builder.setMessage("you will get dl for this event")
        builder.setIcon(R.drawable.ic_info)

        builder.setPositiveButton("Yes") { dialogInterface, which ->
            button.text = "registered"
            Toast.makeText(context, "clicked yes", Toast.LENGTH_LONG).show()

            // Show notification
            context?.let {
                val notificationManager = it.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channelId = "my_channel_id"
                val notificationBuilder = NotificationCompat.Builder(it, channelId)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentTitle("Event Registered")
                    .setContentText("You have successfully registered for the event.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        channelId,
                        "My Channel",
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                    notificationManager.createNotificationChannel(channel)
                }

                notificationManager.notify(1, notificationBuilder.build())
            }

            updateData()
        }

        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(context, "clicked No", Toast.LENGTH_LONG).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

    fun updateData(){
        val sharedPreferences = requireContext().getSharedPreferences("userRefs", Context.MODE_PRIVATE)
        val res = sharedPreferences.getString("userData", null)
        if (res != null) {
            var json= JSONObject(res)

            json.put("dl",json.getInt("dl")+1)
            json.put("total_classes",json.getInt("total_classes")+1)

            val editor = sharedPreferences.edit()
            editor.putString("userData", json.toString())
            editor.commit()
        }
    }
}