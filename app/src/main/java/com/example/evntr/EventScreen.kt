package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class EventScreen : Fragment() {

    lateinit var backEvent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        backEvent = view.findViewById(R.id.Event_Back_Button)

        backEvent.setOnClickListener {
            val backFragment = MainScreen()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.Main_Frame, backFragment)?.commit()
        }
    }

}

