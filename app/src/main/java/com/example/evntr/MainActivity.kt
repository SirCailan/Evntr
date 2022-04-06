package com.example.evntr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// #D49CF2 color to back event
class MainActivity : AppCompatActivity() {
<<<<<<< Updated upstream
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
=======

    lateinit var main: FrameLayout
    lateinit var mainScreen: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* main = findViewById(R.id.Main_Frame)
        mainScreen = MainFragment()

        chooseFragment(mainScreen) */

    }

    /*fun chooseFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.Main_Frame, fragment).commit()

    } */
>>>>>>> Stashed changes
}