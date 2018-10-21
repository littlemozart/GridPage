package com.lee.gridpage.adapter

import android.support.v4.view.PagerAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.lee.gridpage.model.Data

class GridPageAdapter : PagerAdapter() {

    var mList: List<Data>? = null

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return if (mList == null) {
            0
        } else {
            val count = mList!!.size / PAGE_SIZE
            val res = mList!!.size % PAGE_SIZE
            if (res == 0) {
                count
            } else {
                count + 1
            }
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): RecyclerView {
        val recyclerView = RecyclerView(container.context)
        val adapter = GridItemAdapter(container.context)
        val lm = GridLayoutManager(container.context, 4)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = lm
        recyclerView.isMotionEventSplittingEnabled = false
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        adapter.mList = splitList(mList, position)
        adapter.notifyDataSetChanged()
        container.addView(recyclerView)
        return recyclerView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    companion object {
        /**
         * Item count per page.
         */
        const val PAGE_SIZE = 8

        fun splitList(list: List<Data>?, page: Int): List<Data> {
            val data = ArrayList<Data>()
            if (list != null && list.isNotEmpty()) {
                val start = PAGE_SIZE * page
                val end = Math.min(start + PAGE_SIZE, list.size)
                for (i in start until end) {
                    data.add(list[i])
                }
            }
            return data
        }
    }
}