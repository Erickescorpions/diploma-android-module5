package com.erickvazquezs.hellomodulo4.practices.fragments.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erickvazquezs.hellomodulo4.R
import com.erickvazquezs.hellomodulo4.databinding.FragmentBBinding


class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    private var name: String? = ""
    private var email: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString("ARG_NAME")
            email = it.getString("ARG_EMAIL")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvContent.text = "Nombre: $name Correo: $email"

        binding.btnNext.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack("Fragment C")
                .replace(
                    R.id.fragmentContainer,
                    FragmentC.newInstance()
                ).commit()
        }
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_EMAIL = "ARG_EMAIL"

        @JvmStatic
        fun newInstance(name: String, email: String) =
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_EMAIL, email)
                }
            }
    }
}