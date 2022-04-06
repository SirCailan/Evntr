package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainFragment : Fragment() {

<<<<<<< Updated upstream
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
=======
    lateinit var eventsButton: Button
    lateinit var favoritesButton: Button
>>>>>>> Stashed changes

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

<<<<<<< Updated upstream
=======
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventsButton = view.findViewById(R.id.Events_Button)
        favoritesButton = view.findViewById(R.id.Favoritt_Button)

        eventsButton.setOnClickListener {
           // event()
           findNavController().navigate(MainFragmentDirections.actionMainFragmentToEventsFragment())
        }
        favoritesButton.setOnClickListener {
           // favorites()
           findNavController().navigate(MainFragmentDirections.actionMainFragmentToFavoritesFragment())
        }
    }
>>>>>>> Stashed changes
}