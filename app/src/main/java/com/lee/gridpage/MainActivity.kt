package com.lee.gridpage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lee.gridpage.adapter.GridPageAdapter
import com.lee.gridpage.model.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<Data>()
        for (i in 0..20) {
            list.add(Data("${i + 1}", R.mipmap.ic_launcher_round))
        }
        val adapter = GridPageAdapter()
        banner.adapter = adapter
        adapter.mList = list
        adapter.notifyDataSetChanged()

        fab_add.setOnClickListener {
            list.add(0, Data("${list.size + 1}", R.mipmap.ic_launcher_round))
            adapter.notifyDataSetChanged()
        }

        fab_sub.setOnClickListener {
            if (list.isNotEmpty()) {
                list.removeAt(0)
                adapter.notifyDataSetChanged()
            }
        }

        indicator.setViewPager(banner)
    }
}
