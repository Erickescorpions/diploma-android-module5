package com.erickvazquezs.hellomodulo4.practices.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R

class LifecycleActivity : AppCompatActivity() {

    // se utiliza para inicializacion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lifecycle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.e("Lifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Lifecycle", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Lifecycle", "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecycle", "onDestroy")
    }
}