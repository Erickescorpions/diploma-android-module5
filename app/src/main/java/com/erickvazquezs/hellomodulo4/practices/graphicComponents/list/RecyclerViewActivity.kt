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
            AnimalEntity("León", "Amarillo", "https://images.pexels.com/photos/33729835/pexels-photo-33729835.jpeg"),
            AnimalEntity("Armadillo", "Café", "https://images.pexels.com/photos/27785222/pexels-photo-27785222.jpeg"),
            AnimalEntity("Tigre", "Naranja", "https://images.pexels.com/photos/792381/pexels-photo-792381.jpeg"),
            AnimalEntity("Gato", "Gris", "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg"),
            AnimalEntity("Tortuga", "Verde", "https://images.pexels.com/photos/1618606/pexels-photo-1618606.jpeg"),
            AnimalEntity("Hipopotamo", "Gris", "https://images.pexels.com/photos/1131460/pexels-photo-1131460.jpeg"),
            AnimalEntity("Delfin", "Azul", "https://images.pexels.com/photos/64219/dolphin-marine-mammals-water-sea-64219.jpeg")
        )

        val adapter = AnimalAdapter(data)
        adapter.onItemSelected = {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}