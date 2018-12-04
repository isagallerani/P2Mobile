package com.example.nicholas.p2mobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun createMealsService() = retrofit.create(MealsService::class.java)
}
