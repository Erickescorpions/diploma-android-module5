package com.erickvazquezs.hellomodulo4.practices.graphicComponents

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickvazquezs.hellomodulo4.R

class BasicComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basic_components)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val cbCredit = findViewById<CheckBox>(R.id.cbCredit)
        val btNext = findViewById<Button>(R.id.btnNext)
        val rgGenre = findViewById<RadioGroup>(R.id.rgGender)
        val spinner = findViewById<Spinner>(R.id.spinner)

        cbCredit.isChecked = true
        cbCredit.setOnCheckedChangeListener { compoundButton, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_LONG).show()
        }

        rgGenre.setOnCheckedChangeListener { radioGroup, id ->
            val name = getRGGenderLabel(id)
            Toast.makeText(this, "radioButtonSelected = $name", Toast.LENGTH_LONG).show()
        }

        val data = arrayListOf("No seleccion", "Mexico", "Colombia", "Argentina", "Brasil", "Venezuela", "Chile")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int, // viene siendo el indice de los datos
                id: Long
            ) {
                view?.setBackgroundColor(Color.BLUE)

                val textView = view as TextView
                textView.setTextColor(Color.WHITE)

                val itemSelected = data[position]
                val message = "Se ha seleccionado el item: $itemSelected"
                Toast.makeText(this@BasicComponentsActivity, message, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@BasicComponentsActivity, "No se ha seleccionado nada", Toast.LENGTH_SHORT).show()
            }

        }

        btNext.setOnClickListener {
            val itemSelected = spinner.selectedItem
            val selectedOption = getRGGenderLabel(rgGenre.checkedRadioButtonId)
            val cbCreditStatus = cbCredit.isChecked
            val email = etEmail.text.toString()

            if(email.isEmpty() || selectedOption == "Desconocido" || itemSelected == "No seleccion") {
                Toast.makeText(this, "Debes ingresar los datos del formulario", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(etPassword.text.toString() != "Hola123.") {
                Toast.makeText(this, "Credenciales invalidas", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Email= $email, Tarjeta de credito = $cbCreditStatus, Item: $itemSelected, Genero: $selectedOption", Toast.LENGTH_LONG).show()
        }
    }

    private fun getRGGenderLabel(id: Int): String {
        return when (id) {
            R.id.rbWoman -> "Mujer"
            R.id.rbMan -> "Hombre"
            else -> "Desconocido"
        }
    }
}