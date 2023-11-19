package com.example.myapplication.ui.FirstScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.adapters.ViewPager2Adapter
import com.example.myapplication.data.Hotel
import com.example.myapplication.databinding.ItemLayoutBinding
import com.example.myapplication.ui.ViewModel
import com.example.myapplication.ui.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HotelFragment : Fragment() {

    private lateinit var binding: ItemLayoutBinding

    private lateinit var viewModel: ViewModel
    private var hotelData: Hotel? = null
    private lateinit var viewPager2Adapter: ViewPager2Adapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemLayoutBinding.inflate(inflater, container, false)
        val viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ViewModel::class.java)

    Log.d("ItemLayoutBinding","Created")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listPhoto: List<String> = emptyList()

        viewModel.loadingHotel.observe(viewLifecycleOwner){
            uiElement(it)
        }


        viewPager2Adapter = ViewPager2Adapter(listPhoto)
        binding.viewPager2.adapter = viewPager2Adapter


        setupTabLayoutAndViewPager(binding.tablayout,binding.viewPager2)


        binding.nextRoom.setOnClickListener {
            findNavController().navigate(R.id.action_hotelFragment_to_hotelNumberFragment)
        }


    }

    private fun setupTabLayoutAndViewPager (tabLayout: TabLayout, viewPager2: ViewPager2){

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->

            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    // Обновляем фон вкладок при изменении страницы
                    if (position == tab.position) {
                        tab.view.setBackgroundResource(R.drawable.select_false)
                    } else {
                        tab.view.setBackgroundResource(R.drawable.select_true)
                    }
                }
            })

        }.attach()

    }

    private fun uiElement(hotel:Hotel){
        Log.d("uiElement","$hotel")
        viewPager2Adapter.getItem(hotel.image_urls)
        binding.Price.text = hotel.minimal_price.toString()
        binding.BlueText.text = hotel.adress
        binding.rating.text = "5" + hotel.rating_name
            //TODO реализовать разделение на рейтинг
        binding.forTour.text = hotel.price_for_it
        binding.aboutForHotel.text = hotel.about_the_hotel.description
        viewPager2Adapter.getItem(hotel.image_urls)
    }

}