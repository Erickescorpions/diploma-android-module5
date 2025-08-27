package com.erickvazquezs.hellomodulo4.initialPractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R
import com.erickvazquezs.hellomodulo4.practices.explicitIntent.Person

class StartActivity : AppCompatActivity() {

    var selectedArticle: Article? = null

    private val register =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                this.selectedArticle =
                    result.data?.getSerializableExtra("EXTRA_ARTICLE_KEY") as Article
                Toast.makeText(this, "RESULT_OK", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "RESULT_CANCELLED", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.btnOpen)

        button.setOnClickListener {
            val intent = Intent(this, SelectArticleActivity::class.java).apply {
                putExtra("EXTRA_TITLE_KEY", "Select an article")
            }

            register.launch(intent)
        }

        Toast.makeText(this, "On Create", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "On Start", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()

        val articleContainer = findViewById<LinearLayout>(R.id.articleContainer)
        val message = findViewById<TextView>(R.id.message)

        if (selectedArticle == null) {
            message.visibility = View.VISIBLE
            articleContainer.visibility = View.GONE
        } else {
            message.visibility = View.GONE
            articleContainer.visibility = View.VISIBLE

            selectedArticle?.let { a ->
                findViewById<ImageView>(R.id.articleImage).setImageResource(a.imageId)
                findViewById<TextView>(R.id.articleTitle).text = a.name
                findViewById<TextView>(R.id.articlePrice).text = "Price: ${a.price}"
                findViewById<TextView>(R.id.articleQuantity).text = "Quantity: ${a.quantity}"
                findViewById<TextView>(R.id.articleAvailable).text =
                    if (a.available) "Available" else "Not available"
            }

        }

        Toast.makeText(this, "On Resume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "On Pause", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "On Restart", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "On Stop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "On Destroy", Toast.LENGTH_LONG).show()
    }
}