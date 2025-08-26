package com.erickvazquezs.hellomodulo4.practices.implicitIntent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Urgent notice")
                putExtra(Intent.EXTRA_TEXT, "This is a test message")
            }

            startActivity(Intent.createChooser(emailIntent, "Send email with"))

//            val emailIntent = Intent(Intent.ACTION_SENDTO)
//            emailIntent.data = Uri.parse("mailto:")
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Urgent notice")
//            emailIntent.putExtra(Intent.EXTRA_TEXT, "This is a test message on email")
        }

        val btnSendUrl = findViewById<Button>(R.id.btnSendUrl)

        btnSendUrl.setOnClickListener {
            // 
            var urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(Intent.createChooser(urlIntent, "Open with:"))
        }
    }
}