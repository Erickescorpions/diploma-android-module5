package com.erickvazquezs.hellomodulo4.initialPractice

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R

class SelectArticleActivity : AppCompatActivity() {

    val articles: List<Article> = listOf(
        Article("Laptop", 15000.0f, 1, true, R.drawable.laptop),
        Article("Celular", 8500.0f, 1, true, R.drawable.cellphone),
        Article("Audífonos", 1200.0f, 2, false, R.drawable.headphones)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select_article)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title = intent.extras?.getString("EXTRA_TITLE_KEY", "")
        print(title)

        val titleLabel = findViewById<TextView>(R.id.title)
        titleLabel.text = title

        findViewById<ImageView>(R.id.articleImage1).setImageResource(articles[0].imageId)
        findViewById<TextView>(R.id.articleTitle1).text = articles[0].name
        findViewById<TextView>(R.id.articlePrice1).text = articles[0].price.toString()
        findViewById<TextView>(R.id.articleQuantity1).text = articles[0].quantity.toString()
        findViewById<TextView>(R.id.articleAvailable1).text =
            if (articles[0].available) "Disponible" else "No disponible"

        findViewById<ImageView>(R.id.articleImage2).setImageResource(articles[1].imageId)
        findViewById<TextView>(R.id.articleTitle2).text = articles[1].name
        findViewById<TextView>(R.id.articlePrice2).text = articles[1].price.toString()
        findViewById<TextView>(R.id.articleQuantity2).text = articles[1].quantity.toString()
        findViewById<TextView>(R.id.articleAvailable2).text =
            if (articles[1].available) "Disponible" else "No disponible"

        findViewById<ImageView>(R.id.articleImage3).setImageResource(articles[2].imageId)
        findViewById<TextView>(R.id.articleTitle3).text = articles[2].name
        findViewById<TextView>(R.id.articlePrice3).text = articles[2].price.toString()
        findViewById<TextView>(R.id.articleQuantity3).text = articles[2].quantity.toString()
        findViewById<TextView>(R.id.articleAvailable3).text =
            if (articles[2].available) "Disponible" else "No disponible"
    }
}