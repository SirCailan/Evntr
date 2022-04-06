package com.example.evntr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// #D49CF2 color to back event
class MainActivity : AppCompatActivity() {

    lateinit var main: FrameLayout
    lateinit var mainScreen: MainScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< Updated upstream

=======
        main = findViewById(R.id.Main_Frame)
        mainScreen = MainScreen()

        chooseFragment(mainScreen)

    }
    fun chooseFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.Main_Frame, fragment).commit()
>>>>>>> Stashed changes
    }
}