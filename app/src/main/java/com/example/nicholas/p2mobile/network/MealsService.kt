package com.example.nicholas.p2mobile.network

import com.example.nicholas.p2mobile.entities.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsService {

    @GET("latest.php")
    fun getMostRecent(): Call<MealList>

    @GET(("random.php"))
    fun getRandomMeal(): Call<MealList>

    @GET("lookup.php?i=")
    fun getMealDetails(@Query("i")query: String   ): Call<MealList>
}