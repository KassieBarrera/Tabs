package com.example.tabs.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.tabs.Fragment.Tab1
import com.example.tabs.Fragment.Tab2
import com.example.tabs.Fragment.Tab3

class Adaptador(fm: FragmentManager?, val numTabs: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> return Tab1()
            1 -> return Tab2()
            2 -> return Tab3()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return numTabs
    }
}