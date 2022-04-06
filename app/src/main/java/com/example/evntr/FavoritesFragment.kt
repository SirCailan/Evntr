package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FavoritesFragment : Fragment() {

<<<<<<< Updated upstream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
=======
    lateinit var backButton: Button

>>>>>>> Stashed changes
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritt_screen, container, false)
    }

<<<<<<< Updated upstream
=======
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton = view.findViewById(R.id.Favorite_Back_Button)

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}

>>>>>>> Stashed changes

}