package com.example.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.tabs.Adapter.Adaptador
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adaptador = Adaptador(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adaptador

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Tab" + p0!!.text, Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "tab" + p0!!.text, Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                val posicion = p0!!.position
                viewPager.currentItem = posicion
            }
        })
    }
}
