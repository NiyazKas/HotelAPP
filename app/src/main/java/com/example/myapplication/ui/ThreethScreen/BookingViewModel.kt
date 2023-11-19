package com.example.myapplication.ui.ThreethScreen

import android.content.Context
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.booking.BookingData
import com.example.myapplication.data.userData.InformationOnBayer
import com.example.myapplication.retrofit.RetrofitRepository
import kotlinx.coroutines.launch

class BookingViewModel: ViewModel() {

    val repo = RetrofitRepository()

    private val _loadingBookingItem = MutableLiveData<BookingData>()
    val loadingBookingItem: LiveData<BookingData> = _loadingBookingItem

    private val _bayer = MutableLiveData<InformationOnBayer>()
    val informationOnBayer: LiveData<InformationOnBayer> = _bayer

    private val _payError = MutableLiveData<Boolean>()
    val payError: LiveData<Boolean> = _payError

//    private val _loadingBookingItem = MutableLiveData<BookingUiState>()
//    val loadingBookingItem: LiveData<BookingUiState> = _loadingBookingItem

    init {
        viewModelScope.launch {
            loadBookingItem()
        }
    }

    private suspend fun loadBookingItem(){
        //val result = repo.getBookingData()
       val result = repo.getBookingData()
        if (result.isSuccessful){
            //var res1 = listOf(result)
            _loadingBookingItem.postValue(result.body())
           // _loadingBookingItem.postValue(BookingUiState.Success(res1)
        }
    }

     fun validateTourist(phone: Editable,email:String,): Boolean {
         if (phone.isBlank() &&
            email.isBlank()){
             Log.d("validateTourist","TRUE")
         return true
        }else {
             Log.d("validateTourist", "FALSE")
             return false
         }
        // TODO release implement full phone number and mail verification

    }

//    fun payFunction(phone: Editable, email: String):Boolean{
//        return validateTourist(phone, email)
//    }


}