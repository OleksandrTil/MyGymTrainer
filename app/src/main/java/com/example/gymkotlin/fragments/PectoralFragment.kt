package com.example.gymkotlin.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymkotlin.InfoActivity
import com.example.gymkotlin.MainActivity
import com.example.gymkotlin.R
import com.example.gymkotlin.adapter.Constants
import com.example.gymkotlin.adapter.Items
import com.example.gymkotlin.adapter.MyAdapter
import java.util.ArrayList


class PectoralFragment : Fragment(), MyAdapter.OnItemClick {

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
        itemList.add(Items(getString(R.string.bench_press), R.drawable.bench_press))
        itemList.add(Items(getString(R.string.con_hands), R.drawable.con_hands))
        itemList.add(Items(getString(R.string.bench_press_incline), R.drawable.bench_press_incline))
        itemList.add(Items(getString(R.string.push_up_p), R.drawable.push_up_p))
        itemList.add(Items(getString(R.string.bench_press_dumb), R.drawable.bench_press_dumb))
    }

    override fun onItemClick(view: View, pos: Int) {
        val intent = Intent(activity, InfoActivity::class.java ).apply {
            when (pos) {
                0 -> {
                    putExtra(Constants.TEXT,getString(R.string.bench_press_info))
                    putExtra(Constants.IMAGE,R.drawable.pectoral_musc)
                }
                1 -> {
                    putExtra(Constants.TEXT,getString(R.string.con_hands_info))
                    putExtra(Constants.IMAGE,R.drawable.con_hands)
                }
                2 -> {
                    putExtra(Constants.TEXT,getString(R.string.bench_press_incline_info))
                    putExtra(Constants.IMAGE,R.drawable.bench_press_incline)
                }
                3 -> {
                    putExtra(Constants.TEXT,getString(R.string.push_up_p_info))
                    putExtra(Constants.IMAGE,R.drawable.push_up_p)
                }
                4 -> {
                    putExtra(Constants.TEXT,getString(R.string.bench_press_dumb_info))
                    putExtra(Constants.IMAGE,R.drawable.bench_press_dumb)
                }
            }
        }
        startActivity(intent)
    }

}