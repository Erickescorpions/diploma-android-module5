package com.erickvazquezs.hellomodulo4.practices.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erickvazquezs.hellomodulo4.R

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}