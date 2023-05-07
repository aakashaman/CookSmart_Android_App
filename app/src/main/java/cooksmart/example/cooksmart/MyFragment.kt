package cooksmart.example.cooksmart
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.example.dutyleavemanagmentsystem.R

class MyFragment : Fragment(R.layout.fragment_my) {

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView1 = view.findViewById(R.id.eventHeading)
        textView2 = view.findViewById(R.id.eventDetails)
    }

    fun updateTextViews(text1: String, text2: String) {
        textView1.text = text1
        textView2.text = text2
    }
}
