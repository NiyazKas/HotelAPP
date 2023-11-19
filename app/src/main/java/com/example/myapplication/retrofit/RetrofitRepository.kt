package com.example.myapplication.retrofit

import android.util.Log
import com.example.myapplication.data.Hotel
import com.example.myapplication.data.HotelItem.HotelItem
import com.example.myapplication.data.booking.BookingData
import retrofit2.Response

class  RetrofitRepository {

    suspend fun getHotelData(): Response<Hotel> {
        Log.d("LOG", "Началась загрузка из RetrofitRepository")
        return RetrofitInstance.api.getHotel()
    }

    suspend fun getHotelItemData(): Response<HotelItem>{
        return RetrofitInstance.api.getItemHotel()
    }

    suspend fun getBookingData(): Response<BookingData>{
        return RetrofitInstance.api.getBookingItem()
    }


}