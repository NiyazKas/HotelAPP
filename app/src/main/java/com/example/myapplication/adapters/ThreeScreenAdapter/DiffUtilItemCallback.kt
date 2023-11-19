package com.example.myapplication.adapters.ThreeScreenAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.data.HotelItem.HotelItem
import com.example.myapplication.data.HotelItem.Room
import com.example.myapplication.data.userData.UserData

class DiffUtilItemCallback: DiffUtil.ItemCallback<Room>() {

    override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem == newItem
    }


}