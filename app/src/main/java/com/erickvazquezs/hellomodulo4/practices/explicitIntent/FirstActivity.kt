package com.erickvazquezs.hellomodulo4.practices.explicitIntent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R

class FirstActivity : AppCompatActivity() {

    private val register =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val booleanRes = result.data?.getBooleanExtra("EXTRA_BOOLEAN_KEY", false)
                val person = result.data?.getSerializableExtra("EXTRA_PERSON_KEY") as Person

                Toast.makeText(this, "RESULT_OK $booleanRes, ${person.name}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "RESULT_CANCELLED", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // para colocar un toolbar que va a tener un back
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Primer Activity"

        val button = findViewById<Button>(R.id.btnOpen)

        button.setOnClickListener {

            val extraBundle = Bundle().apply {
                putBoolean("EXTRA_IS_GRADUATE_KEY", false)
                putString("EXTRA_MAJOR", "Ingenieria en Computacion")
            }

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Erick")
                putExtra("EXTRA_AGE_KEY", 23)
                putExtra("EXTRA_TOTEM_KEY", "Perro")
                putExtra("EXTRA_PI_VALUE", 3.1416)
                putExtra("EXTRA_BUNDLE_KEY", extraBundle)
            }

//            startActivity(intent)
            register.launch(intent)
        }
    }
}