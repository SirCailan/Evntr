package com.example.evntr.EventsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.evntr.API.ApiEventLite
import com.example.evntr.EventsAdapter
import com.example.evntr.R


class EventsFragment : Fragment() {
    private val viewModel: EventsViewModel by viewModels()

    private lateinit var backButton: Button
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var myAdapter: EventsAdapter
    private lateinit var loadingSpinner: ProgressBar
    private lateinit var sortSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //backButton = view.findViewById(R.id.Event_Back_Button)
        sortSpinner = view.findViewById(R.id.events_sort_spinner)

        ArrayAdapter.createFromResource(
            view.context,
            R.array.sort_array,
            android.R.layout.simple_spinner_item
        ).also { spinnerAdapter ->
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sortSpinner.adapter = spinnerAdapter
        }

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        loadingSpinner = view.findViewById(R.id.events_progressbar)

        myRecyclerView = view.findViewById(R.id.Event_RecylerView)
        myLayoutManager = LinearLayoutManager(activity)

        myRecyclerView.layoutManager = myLayoutManager

        
        viewModel.fetchAllEvents(Volley.newRequestQueue(context), sortBy = 0) { events ->
            if (events != null) {
                myAdapter = EventsAdapter(events)

                loadingSpinner.visibility = View.GONE

                myRecyclerView.adapter = myAdapter

                onSelectSpinnerItem()
            }
        }
    }

    fun onSelectSpinnerItem() {
        sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (parent != null) {
                    viewModel.fetchAllEvents(Volley.newRequestQueue(context), sortBy = position) { events ->
                        if (events != null) {
                            myAdapter.swapDataset(events)
                            myRecyclerView.scrollToPosition(0)
                        }
                    }
                }
            }

        }
    }

}