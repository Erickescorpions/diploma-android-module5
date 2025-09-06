package com.erickvazquezs.hellomodulo4.practices.fragments.navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R
import com.erickvazquezs.hellomodulo4.databinding.ActivityFragmentNavigationBinding

class FragmentNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFragmentNavigationBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, FragmentA.newInstance())
            .commit()
    }
}