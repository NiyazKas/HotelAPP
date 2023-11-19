package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.retrofit.RetrofitRepository

class ViewModelFactory: ViewModelProvider.Factory  {


    private val repository = RetrofitRepository()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Добавьте сюда другие типы ViewModel, если необходимо
        if (modelClass.isAssignableFrom(com.example.myapplication.ui.ViewModel::class.java)) {
            return com.example.myapplication.ui.ViewModel(repository) as T
        }
        // Обработка других типов ViewModel, если необходимо
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}