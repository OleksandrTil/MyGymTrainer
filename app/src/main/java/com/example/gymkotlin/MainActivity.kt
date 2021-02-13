package com.example.gymkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymkotlin.adapter.Constants
import com.example.gymkotlin.adapter.Items
import com.example.gymkotlin.adapter.MyAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClick {

    private var itemList = ArrayList<Items>()
    private var listener: MyAdapter.OnItemClick = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainItems()
        init()
    }

   private fun init() {
        val rcView: RecyclerView? = findViewById(R.id.rcView)
        val adapter = MyAdapter(this, itemList, listener)
        rcView?.layoutManager = LinearLayoutManager(this)
        adapter.setClickListener(listener)
        rcView?.adapter = adapter
    }

    private fun mainItems() {
        itemList.add(Items(getString(R.string.pectoral_musc), R.drawable.pectoral_musc))
        itemList.add(Items(getString(R.string.legs_musc), R.drawable.legs_musc))
        itemList.add(Items(getString(R.string.back_musc), R.drawable.back_musc))
        itemList.add(Items(getString(R.string.bic_musc), R.drawable.bic_musc))
        itemList.add(Items(getString(R.string.tric_musc), R.drawable.tric_musc))
        itemList.add(Items(getString(R.string.delta_musc), R.drawable.delta_musc))
    }

    override fun onItemClick(view: View, pos: Int) {
        val intent = Intent(this, ExercisesActivity::class.java).apply {
            putExtra(Constants.POSITION, pos)
        }
        startActivity(intent)
    }

}