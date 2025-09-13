package com.erickvazquezs.hellomodulo4.practices.fragments.bottomNav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.erickvazquezs.hellomodulo4.R
import com.erickvazquezs.hellomodulo4.databinding.ActivityBottomNavBinding

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.navBottom.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.pageAlbum -> {
                    return@setOnItemSelectedListener true
                }
                R.id.pageCamera -> {
                    return@setOnItemSelectedListener true
                }
                R.id.pageHelp -> {
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}