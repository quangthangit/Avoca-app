package com.example.avoca_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.avoca_app.R

class Event : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    companion object {
        /**
         * Create a new instance of this fragment.
         * You no longer need parameters as this is a simple fragment.
         */
        @JvmStatic
        fun newInstance() = Event()
    }
}
