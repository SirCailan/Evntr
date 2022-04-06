package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FavoritesFragment : Fragment() {

    lateinit var backFavorite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritt_screen, container, false)






    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backFavorite = view.findViewById(R.id.Favorite_Back_Button)

        backFavorite.setOnClickListener {
            val backFragment = MainScreen()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.Main_Frame, backFragment)?.commit()
        }
    }


}


