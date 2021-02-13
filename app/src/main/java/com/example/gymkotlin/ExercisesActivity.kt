package com.example.gymkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymkotlin.adapter.Constants
import com.example.gymkotlin.adapter.Items
import com.example.gymkotlin.adapter.MyAdapter
import com.example.gymkotlin.fragments.*
import java.util.ArrayList

class ExercisesActivity : AppCompatActivity(){

   var position:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)
        init()
    }

    private fun init() {
       position = intent.getIntExtra(Constants.POSITION,0)
        when(position){
            0-> {
                val pectoralFragment = supportFragmentManager.beginTransaction()
                pectoralFragment.add(R.id.container,PectoralFragment())
                pectoralFragment.commit()
            }
            1-> {
                val legsFragment = supportFragmentManager.beginTransaction()
                legsFragment.add(R.id.container, LegsFragment())
                legsFragment.commit()
            }
            2-> {
                val backFragment = supportFragmentManager.beginTransaction()
                backFragment.add(R.id.container,BackFragment())
                backFragment.commit()
            }
            3-> {
                val bicFragment = supportFragmentManager.beginTransaction()
                bicFragment.add(R.id.container, BicFragment())
                bicFragment.commit()
            }
            4-> {
                val tricFragment = supportFragmentManager.beginTransaction()
                tricFragment.add(R.id.container, TricFragment())
                tricFragment.commit()
            }
            5-> {
                val deltaFragment = supportFragmentManager.beginTransaction()
                deltaFragment.add(R.id.container, DeltaFragment())
                deltaFragment.commit()
            }
        }

    }
}