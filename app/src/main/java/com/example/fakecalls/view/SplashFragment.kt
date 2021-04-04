package com.example.fakecalls.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fakecalls.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashFragment  : Fragment(),CoroutineScope {


    //https://medium.com/@declannnadozie/create-a-splash-screen-in-android-with-kotlin-coroutines-and-fragment-da27fb1a946a

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launch{
            delay(3000)
            //Dispatchers.Main is telling Kotlin, this Scope runs on the Main thread, which is the UI thread
            withContext(Dispatchers.Main){
                (activity as MainActivity).bottomNavVisibility(false)
                val actions = SplashFragmentDirections.actionSplashFragmentToCallFragment()
                findNavController().navigate(actions)
            }
        }


    }
}