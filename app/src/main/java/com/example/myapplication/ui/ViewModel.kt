package com.example.myapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Hotel
import com.example.myapplication.data.HotelItem.HotelItem
import com.example.myapplication.data.booking.BookingData
import com.example.myapplication.retrofit.RetrofitRepository
import kotlinx.coroutines.launch

class ViewModel(private val repository: RetrofitRepository): ViewModel() {


    private val _loadingHotel = MutableLiveData<Hotel>()
    val loadingHotel: LiveData<Hotel> = _loadingHotel

    private val _loadingHotelItem = MutableLiveData<HotelItem>()
    val loadingHotelItem: LiveData<HotelItem> = _loadingHotelItem

    private val _loadingBookingItem = MutableLiveData<BookingData>()
    val loadingBookingItem: LiveData<BookingData> = _loadingBookingItem

    init {
        viewModelScope.launch {
            loadHotelData()
        }
        viewModelScope.launch {
            loadHotelItem()
        }
        viewModelScope.launch {
            loadBookingItem()
        }
    }

    private suspend fun loadHotelItem(){
        val result = repository.getHotelItemData()
        if (result.isSuccessful){
            _loadingHotelItem.postValue(result.body())
        }
    }


    private suspend fun loadHotelData() {
        val result = repository.getHotelData()
        if (result.isSuccessful) {
            Log.d("loadHotelData","${result.body()}")
            _loadingHotel.postValue(result.body())
        }
    }

    private suspend fun loadBookingItem(){
        val result = repository.getBookingData()
        if (result.isSuccessful){
            _loadingBookingItem.postValue(result.body())
        }
    }

//    fun checkRepository(repository: RetrofitRepository){
//        val result
//    }

    sealed class BookingUiState {

        object Idle: BookingUiState()

        object Empty: BookingUiState()

        data class Success(val articles: List<BookingData>): BookingUiState()

    }
}