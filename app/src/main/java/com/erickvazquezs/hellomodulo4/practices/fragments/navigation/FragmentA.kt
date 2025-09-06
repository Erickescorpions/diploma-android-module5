package com.erickvazquezs.hellomodulo4.practices.fragments.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erickvazquezs.hellomodulo4.R
import com.erickvazquezs.hellomodulo4.databinding.FragmentABinding


class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val name = binding.etUserName.text.toString()
            val email = binding.etEmail.text.toString()

            parentFragmentManager
                .beginTransaction()
                .addToBackStack("Fragment B")
                .replace(
                    R.id.fragmentContainer,
                    FragmentB.newInstance(name, email)
                ).commit()
        }

        binding.btnShowC.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .replace(
                    R.id.fragmentContainer,
                    FragmentC.newInstance()
                ).commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentA()
    }
}