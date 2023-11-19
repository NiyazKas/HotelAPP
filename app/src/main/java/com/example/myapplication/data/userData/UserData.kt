package com.example.myapplication.data.userData

data class UserData(
    val name: String,
    val soName: String,
    val birtDay: Int,
    val citizenship: String,
    val numberOfInternationalPassport: Int,
    val validityPeriodOfInternationalPassport: Int,
    val expandable: Boolean = EXPANDABLE_VIEW

        ){
    companion object{
        const val EXPANDABLE_VIEW = false
    }
}