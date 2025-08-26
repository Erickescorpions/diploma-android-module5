package com.erickvazquezs.hellomodulo4.practices.explicitIntent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView = findViewById<TextView>(R.id.textInfo)
        var infoReceived = ""

        intent.extras?.let { info ->
            if (info.containsKey("EXTRA_NAME_KEY")) {
                infoReceived += info.getString("EXTRA_NAME_KEY", "")
            }

            if (info.containsKey("EXTRA_AGE_KEY")) {
                infoReceived += "\nEdad: " + info.getInt("EXTRA_AGE_KEY", 20)
            }

            if (info.containsKey("EXTRA_TOTEM_KEY")) {
                infoReceived += "\nTu totem de tierra de osos es: " + info.getString(
                    "EXTRA_TOTEM_KEY",
                    "Oso"
                )
            }

            if (info.containsKey("EXTRA_BUNDLE_KEY")) {
                val bundle = info.getBundle("EXTRA_BUNDLE_KEY")

                bundle?.getBoolean("EXTRA_IS_GRADUATE_KEY")?.let { isGraduate ->
                    infoReceived += "\nEstá graduado: " + if (isGraduate) "Sí" else "No"
                }

                bundle?.getString("EXTRA_MAJOR")?.let { major ->
                    infoReceived += "\nCampo de estudios: $major"
                }
            }
        }

        val piValue = intent.getDoubleExtra("EXTRA_PI_VALUE", 3.14)

        piValue.let {
            infoReceived += "\nEl valor de pi es: $piValue"
        }

        textView.text = infoReceived


        val btnReturn = findViewById<Button>(R.id.btnReturnRes)

        btnReturn.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_BOOLEAN_KEY", false)
                putExtra("EXTRA_PERSON_KEY", Person("Juan", 23, false))
            }

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}