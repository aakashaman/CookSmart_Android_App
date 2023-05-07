package cooksmart.example.cooksmart

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.example.dutyleavemanagmentsystem.R
import org.json.JSONObject

class Account : Fragment() {
    lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {

        v = inflater.inflate(R.layout.fragment_account,container,false)

        val sharedPreferences = requireContext().getSharedPreferences("userRefs", Context.MODE_PRIVATE)

        var dl=0
        var total_classes=0
        var attended_classes=0;


        val res = sharedPreferences.getString("userData", null)
        if (res != null) {
            var json=JSONObject(res)

            dl=json.getInt("dl")
            total_classes=json.getInt("total_classes")
            attended_classes=json.getInt("attended_classes")

            v.findViewById<TextView>(R.id.dl).text= dl.toString()
            v.findViewById<TextView>(R.id.attended_classes).text= attended_classes.toString()
            v.findViewById<TextView>(R.id.total_classes).text= total_classes.toString()


            var progress_text=v.findViewById<TextView>(R.id.progress_text)
            var progress_bar=v.findViewById<ProgressBar>(R.id.progress_bar)

            var attendance = ((dl+attended_classes)*100)/total_classes

            progress_text.text=attendance.toString()
            progress_bar.progress=attendance
        }
        return  v
    }
}