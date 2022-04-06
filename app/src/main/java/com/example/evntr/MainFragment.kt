package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    lateinit var event: Button
    lateinit var favorites: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        event = view.findViewById(R.id.Events_Button)
        favorites = view.findViewById(R.id.Favoritt_Button)

        event.setOnClickListener {
            event()
        }
        favorites.setOnClickListener {
            favorites()
        }
    }

    fun event() {
        CoroutineScope(Dispatchers.IO).launch {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(false)
                replace<EventScreen>(R.id.Main_Frame)
            }
        }
    }

    fun favorites() {
        CoroutineScope(Dispatchers.IO).launch {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(false)
                replace<FavorittScreen>(R.id.Main_Frame)
            }


        }


    }
}