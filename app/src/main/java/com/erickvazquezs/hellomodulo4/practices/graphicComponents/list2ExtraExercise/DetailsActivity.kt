package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list2ExtraExercise

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erickvazquezs.hellomodulo4.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = findViewById<RecyclerView>(R.id.contactsList)

        val data = listOf(
            ContactEntity("Juan Escutia", "55 8686 7593", R.drawable.img1),
            ContactEntity("Mariana López", "55 3245 1122", R.drawable.img5),
            ContactEntity("Carlos Ramírez", "55 7890 4567", R.drawable.img2),
            ContactEntity("Ana Torres", "55 9988 7766", R.drawable.img6),
            ContactEntity("Luis Hernández", "55 1234 5678", R.drawable.img3),
            ContactEntity("Sofía Martínez", "55 4321 8765", R.drawable.img7),
            ContactEntity("Fernando García", "55 5566 3344", R.drawable.img4),
            ContactEntity("Laura Méndez", "55 6677 8899", R.drawable.img8)
        )


        val adapter = ContactsAdapter(data)
        adapter.onItemSelected = {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}