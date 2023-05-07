package cooksmart.example.cooksmart

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.dutyleavemanagmentsystem.R

class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var imageview=findViewById<ImageView>(R.id.imageView)

        Handler().postDelayed({
            imageview.animate().apply {
               duration=200
                scaleX(0.0F)
                scaleY(0.0F)
            }.start()
        },1800)

        Handler().postDelayed({
            var intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}