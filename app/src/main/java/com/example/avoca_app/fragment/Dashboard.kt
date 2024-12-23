package com.example.avoca_app.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avoca_app.R
import com.google.android.material.tabs.TabLayout
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.adapter.FragmentStateAdapter

class Dashboard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val tabLayout = rootView.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = rootView.findViewById<ViewPager2>(R.id.viewPager)

        // Setup ViewPager2 adapter to display fragments
        val pagerAdapter = DashboardPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        // Link TabLayout and ViewPager2
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.setCurrentItem(it.position, true)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)?.select()
            }
        })

        return rootView
    }

    // Adapter to manage fragments in ViewPager2
    private inner class DashboardPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return 4
        }


        override fun createFragment(position: Int): Fragment {
            Log.d("DashboardPagerAdapter", "Current position: $position")
            return when (position) {
                0 -> Participants()
                1 -> Event.newInstance()
                2 -> MissionFragment()
                3 -> LeaderBoardFragment()
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }
    }
}
