package com.example.myapplication.ui.ThreethScreen

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.booking.BookingData
import com.example.myapplication.databinding.NewExampleTestLayoutBinding

class BookingFragment : Fragment(R.layout.new_example_test_layout) {

    private lateinit var binding: NewExampleTestLayoutBinding
    private lateinit var viewModel: BookingViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewExampleTestLayoutBinding.inflate(layoutInflater, container, false)
//
//        val viewModelFactory = ViewModelFactory()
//        viewModel = ViewModelProvider(this, viewModelFactory)
//            .get(viewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = BookingViewModel()

        var phoneInfo = binding.phone.text
        var emailInfo = binding.email.text
        binding.payButton.setOnClickListener {
            if (payButton(phone = phoneInfo!!, emailInfo.toString())){
                Log.d("button","$phoneInfo,$emailInfo")
                Toast.makeText(requireContext(),"Sucsses",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_bookingFragment_to_congratulationScreen)
            }else{
                Log.d("button","$phoneInfo,$emailInfo")
                Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
            }


        }




        binding.icons.setOnClickListener {
            if (ENABLE_TOURIST1_VIEW) {
                binding.ChildView.visibility = View.VISIBLE
                binding.icons.setImageResource(R.drawable.icons_false)
                ENABLE_TOURIST1_VIEW = false
            } else {
                binding.ChildView.visibility = View.GONE
                binding.icons.setImageResource(R.drawable.icons_true)
                ENABLE_TOURIST1_VIEW = true
            }


        }

        binding.iconsAddTourist.setOnClickListener {
            binding.cardViewTourist2.visibility = View.VISIBLE
            ENABLE_TOURIST_ADD = true
        }


            binding.iconsTourist2.setOnClickListener {
                if (ENABLE_TOURIST2_VIEW) {
                    binding.ChildViewSecond.visibility = View.VISIBLE
                    binding.iconsTourist2.setImageResource(R.drawable.icons_false)
                    ENABLE_TOURIST2_VIEW = false
                } else {
                    binding.ChildViewSecond.visibility = View.GONE
                    binding.iconsTourist2.setImageResource(R.drawable.icons_true)
                    ENABLE_TOURIST2_VIEW = true
                }
        }


    }

    private fun payButton(phone: Editable, email:String): Boolean {
        return viewModel.validateTourist(phone,email)
    }


    private fun handleUiState(uiState: BookingData) {
    }

    companion object {
        var ENABLE_TOURIST1_VIEW = true
        var ENABLE_TOURIST2_VIEW = true
        var ENABLE_TOURIST3_VIEW = true
        var ENABLE_TOURIST_ADD = false
    }
}
//        adapterDelegateItem.items = listOf(
//            BookingData(
//                "aaaa",
//                "ssss",
//                123,
//                345,
//                "ddd",
//                "wwww",
//                23,
//                125,
//                "yyyy",
//                "tttt",
//                "hhjjg",
//                777,
//                "jkjhg",
//                "fgjfgj",
//                212152
//            )
//        )
//        adapterDelegateItem.swapItems(listOf(uiState))


//    private fun handleUiState(uiState: BookingViewModel.BookingUiState){
//        when(uiState) {
//            BookingViewModel.BookingUiState.Empty -> TODO()
//            BookingViewModel.BookingUiState.Idle -> TODO()
//            is BookingViewModel.BookingUiState.Success -> TODO()
//        }
//    }

//        binding.RecyclerView.adapter = adapter
//        adapter.apply {
//            items = listOf(BookingListItem(emptyList()))
//            notifyDataSetChanged()
//        }
//        binding.tab.setOnClickListener {
//           val inflater = LayoutInflater.from(requireContext())
//            val newElement = inflater.inflate(R.layout.fragment_booking, null)
//            binding.elementContainer.addView(newElement)
//        }
//
//        binding.tab1.setOnClickListener {
//            openList = !openList
//            // В зависимости от значения openList, показываем или скрываем expandableLayout
//            if (openList) {
//                binding.expandableLayout1.visibility = View.VISIBLE
//            } else {
//                binding.expandableLayout1.visibility = View.GONE
//            }
//        }