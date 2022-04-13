package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.volley.toolbox.Volley
import com.example.evntr.EventsScreen.EventsViewModel


class TitleFragment : Fragment() {
    private val viewModel: EventsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_title_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchAllEvents(Volley.newRequestQueue(context), sortBy = 0) { success ->
            findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToEventsFragment())
        }
    }
}