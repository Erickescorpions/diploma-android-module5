package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list2ExtraExercise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R
import com.erickvazquezs.hellomodulo4.databinding.ActivityContactViewBinding
import com.erickvazquezs.hellomodulo4.databinding.ActivityFirstBinding

class ContactViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityContactViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val contact: ContactEntity = intent.extras?.getSerializable("EXTRA_CONTACT_KEY") as ContactEntity

        binding.contactName.text = contact.name
        binding.contactPhoneNumber.text = contact.phoneNumber
        binding.contactPhoto.setImageResource(contact.photo ?: R.drawable.img_placeholder)
    }
}