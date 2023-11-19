package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ViewPagerLayoutBinding

class ViewPager2Adapter(
    private var items: List<String>,
) : RecyclerView.Adapter<ViewPager2Adapter.MyViewHolder>() {

    fun getItem(ListItems: List<String>){
        items = ListItems
        notifyDataSetChanged()
    }


        class MyViewHolder(val bind : ViewPagerLayoutBinding): RecyclerView.ViewHolder(bind.root) {
            fun binding(data: List<String>) = with(bind) {
                Glide.with(itemView)
                    .load(data[layoutPosition])
                    .centerCrop()
                    .into(imageView)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val bind = ViewPagerLayoutBinding.inflate(
                LayoutInflater.from(parent.context),parent,
                false
            )
            return ViewPager2Adapter.MyViewHolder(bind)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.binding(items)
        }
    }
