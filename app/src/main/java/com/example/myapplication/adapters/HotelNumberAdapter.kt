package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.adapters.ThreeScreenAdapter.DiffUtilItemCallback
import com.example.myapplication.data.HotelItem.Room
import com.example.myapplication.databinding.ItemLayoutHotelNumberBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HotelNumberAdapter(

): ListAdapter<Room,HotelNumberAdapter.MyViewHolder>(DiffUtilItemCallback())  {

    private val viewPager2Adapter = ViewPager2Adapter(listOf())

    class MyViewHolder(val view : ItemLayoutHotelNumberBinding): RecyclerView.ViewHolder(view.root)



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        addUi(data,holder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bind = ItemLayoutHotelNumberBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return MyViewHolder(bind)
    }

    private fun addUi(roomItem: Room,holder:MyViewHolder) {
        holderRealization(holder, roomItem)
        viewPager2Adapter.getItem(ListItems = roomItem.image_urls)
        setupTabLayoutAndViewPager(holder.view.tabLayout,holder.view.vp2)

    }

    private fun holderRealization(holder: MyViewHolder, roomItem: Room) {
        holder.view.vp2.adapter = viewPager2Adapter
        holder.view.nextRoom.setOnClickListener {
            it.findNavController().navigate(R.id.action_hotelNumberFragment_to_bookingFragment)
        }
        holder.view.FirstText.text = roomItem.name
        holder.view.itemFirst.text = roomItem.peculiarities[0]
        holder.view.itemSecond.text = roomItem.peculiarities[1]
        holder.view.price.text = roomItem.price.toString()
        holder.view.pricePer.text = roomItem.price_per
    }

    private fun setupTabLayoutAndViewPager (tabLayout: TabLayout, viewPager2: ViewPager2) {

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->

            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position == tab.position) {
                        tab.view.setBackgroundResource(R.drawable.select_false)
                    } else {
                        tab.view.setBackgroundResource(R.drawable.select_true)
                    }
                }
            })
        }.attach()
    }

}