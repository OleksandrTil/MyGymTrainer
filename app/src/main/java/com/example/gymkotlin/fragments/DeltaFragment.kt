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

class DeltaFragment: Fragment(), MyAdapter.OnItemClick {

    private var itemList = ArrayList<Items>()
    private var listener: MyAdapter.OnItemClick = this
    private var mContext: Context? = context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        itemList.add(Items(getString(R.string.bench_press_stand), R.drawable.bench_press_stand))
        itemList.add(Items(getString(R.string.pull_bar_chin), R.drawable.pull_bar_chin))
        itemList.add(Items(getString(R.string.dumb_press_seat), R.drawable.dumb_press_seat))
        itemList.add(Items(getString(R.string.stand_dumb_swing), R.drawable.stand_dumb_swing))
    }

    override fun onItemClick(view: View, pos: Int) {
        val intent = Intent(activity, InfoActivity::class.java).apply {
            when (pos) {
                0 -> {
                    putExtra(Constants.TEXT, getString(R.string.bench_press_stand_info))
                    putExtra(Constants.IMAGE, R.drawable.bench_press_stand)
                }
                1 -> {
                    putExtra(Constants.TEXT, getString(R.string.pull_bar_chin_info))
                    putExtra(Constants.IMAGE, R.drawable.pull_bar_chin)
                }
                2 -> {
                    putExtra(Constants.TEXT, getString(R.string.dumb_press_seat_info))
                    putExtra(Constants.IMAGE, R.drawable.dumb_press_seat)
                }
                3 -> {
                    putExtra(Constants.TEXT, getString(R.string.stand_dumb_swing_info))
                    putExtra(Constants.IMAGE, R.drawable.stand_dumb_swing)
                }
            }
        }
        startActivity(intent)
    }

}