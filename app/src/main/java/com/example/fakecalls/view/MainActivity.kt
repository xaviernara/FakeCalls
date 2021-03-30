package com.example.fakecalls.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fakecalls.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count1 : Int = 0
        var count2 : Int = 0


        BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){


                R.id.call_menu->{
                    val badge = bottomNavigation.getOrCreateBadge(R.id.call_menu)

                    badge.isVisible = true
                    badge.number = count1++
                    true

                }
                R.id.logout_menu->{ val badge = bottomNavigation.getOrCreateBadge(R.id.logout_menu)

                    badge.isVisible = true
                    badge.number = count2++
                    true}

                else ->  false
            }
        }
    }


}