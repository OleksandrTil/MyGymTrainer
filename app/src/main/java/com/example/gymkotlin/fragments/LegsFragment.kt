package com.example.gymkotlin.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymkotlin.InfoActivity
import com.example.gymkotlin.R
import com.example.gymkotlin.adapter.Constants
import com.example.gymkotlin.adapter.Items
import com.example.gymkotlin.adapter.MyAdapter
import java.util.ArrayList

class LegsFragment : Fragment(), MyAdapter.OnItemClick {

    private var itemList = ArrayList<Items>()
    private var listener: MyAdapter.OnItemClick = this
    private var mContext: Context? = context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_exercises, container, false)
        mainItems()
        val rcView: RecyclerView? = view.findViewById(R.id.rcView)
        val adapter = MyAdapter(activity, itemList, listener)
        rcView?.layoutManager = LinearLayoutManager(activity)
        adapter.setClickListener(listener)
        rcView?.adapter = adapter
        return view
    }

    private fun mainItems() {
        itemList.add(Items(getString(R.string.squats), R.drawable.squats))
        itemList.add(Items(getString(R.string.leg_press), R.drawable.leg_press))
        itemList.add(Items(getString(R.string.deadlift), R.drawable.deadlift))
        itemList.add(Items(getString(R.string.r_deadlift), R.drawable.r_deadlift))
        itemList.add(Items(getString(R.string.lifting_to_socks), R.drawable.lifting_to_socks))
    }

    override fun onItemClick(view: View, pos: Int) {
        val intent = Intent(activity, InfoActivity::class.java ).apply {
            when (pos) {
                0 -> {
                    putExtra(Constants.TEXT,getString(R.string.squats_info))
                    putExtra(Constants.IMAGE, R.drawable.squats)
                }
                1 -> {
                    putExtra(Constants.TEXT,getString(R.string.leg_press_info))
                    putExtra(Constants.IMAGE, R.drawable.leg_press)
                }
                2 -> {
                    putExtra(Constants.TEXT,getString(R.string.deadlift_info))
                    putExtra(Constants.IMAGE, R.drawable.deadlift)
                }
                3 -> {
                    putExtra(Constants.TEXT,getString(R.string.r_deadlift_info))
                    putExtra(Constants.IMAGE, R.drawable.r_deadlift)
                }
                4 -> {
                    putExtra(Constants.TEXT,getString(R.string.lifting_to_socks_info))
                    putExtra(Constants.IMAGE, R.drawable.lifting_to_socks)
                }
            }
        }
        startActivity(intent)
    }

}