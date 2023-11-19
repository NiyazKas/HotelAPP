package com.example.myapplication.ui.SecondScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.adapters.HotelNumberAdapter
import com.example.myapplication.adapters.ViewPager2Adapter
import com.example.myapplication.data.HotelItem.HotelItem
import com.example.myapplication.data.HotelItem.Room
import com.example.myapplication.databinding.FragmentHotelNumberBinding
import com.example.myapplication.ui.ViewModel
import com.example.myapplication.ui.ViewModelFactory

class HotelNumberFragment : Fragment() {

    private lateinit var adapterRoomItem: HotelNumberAdapter
    private lateinit var viewModel: ViewModel
    private lateinit var binding: FragmentHotelNumberBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ViewModel::class.java)
        binding = FragmentHotelNumberBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()




    }

    private fun setupUI() {
        adapterRoomItem = HotelNumberAdapter()
        binding.RecyclerView.adapter = adapterRoomItem
        viewModel.loadingHotelItem.observe(viewLifecycleOwner){
            var roomItem: List<Room> = it.rooms
            adapterRoomItem.submitList(roomItem)
        }

    }
}