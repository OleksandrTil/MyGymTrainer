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

class TricFragment : Fragment(), MyAdapter.OnItemClick {

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
        itemList.add(Items(getString(R.string.narrow_bench_press), R.drawable.narrow_bench_press))
        itemList.add(Items(getString(R.string.ext_arm_block), R.drawable.ext_arm_block))
        itemList.add(Items(getString(R.string.dumbbell_bench_press_head), R.drawable.dumbbell_bench_press_head))
        itemList.add(Items(getString(R.string.french_bench_press), R.drawable.french_bench_press))
    }

    override fun onItemClick(view: View, pos: Int) {
        val intent = Intent(activity, InfoActivity::class.java ).apply {
            when (pos) {
                0 -> {
                    putExtra(Constants.TEXT,getString(R.string.narrow_bench_press_info))
                    putExtra(Constants.IMAGE, R.drawable.narrow_bench_press)
                }
                1 -> {
                    putExtra(Constants.TEXT,getString(R.string.ext_arm_block_info))
                    putExtra(Constants.IMAGE, R.drawable.ext_arm_block)
                }
                2 -> {
                    putExtra(Constants.TEXT,getString(R.string.dumbbell_bench_press_head_info))
                    putExtra(Constants.IMAGE, R.drawable.dumbbell_bench_press_head)
                }
                3 -> {
                    putExtra(Constants.TEXT,getString(R.string.french_bench_press_info))
                    putExtra(Constants.IMAGE, R.drawable.french_bench_press)
                }
            }
        }
        startActivity(intent)
    }

}