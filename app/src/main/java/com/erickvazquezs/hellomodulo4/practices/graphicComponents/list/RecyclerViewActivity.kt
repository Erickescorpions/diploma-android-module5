package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erickvazquezs.hellomodulo4.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = findViewById<RecyclerView>(R.id.list)

        val data = listOf(
            AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Armadillo", "Cafe", ""),
            AnimalEntity("Tigre", "Naranja", ""),
            AnimalEntity("Gato", "Gris", ""),
            AnimalEntity("Tortuga", "Verde", ""),
        )

        val adapter = AnimalAdapter(data)
        adapter.onItemSelected = {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}