package com.example.nicholas.p2mobile.scenarios_main

import com.example.nicholas.p2mobile.entities.Meal
import com.example.nicholas.p2mobile.entities.MealList
import com.example.nicholas.p2mobile.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(val view : MainContract.View) : MainContract.Presenter {
    override fun onLoadList() {

        view.showLoading()

        val mealsService = RetrofitInitializer().createMealsService()

        val call = mealsService.getMostRecent()

        call.enqueue(
                object : Callback<MealList> {
                    override fun onFailure(call: Call<MealList>, t: Throwable) {
                        view.hideLoading()
                        view.showMessage("Falha na conexão. Verifique o acesso à Internet")
                    }

                    override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                        view.hideLoading()
                        if (response.body() != null) {
                            view.showList(response.body()!!.meals)
                        } else {
                            view.showMessage("Essa refeição não está disponível")
                        }
                    }
                })
    }

    override fun onClickMeal(meal: Meal) {
        val mealsService = RetrofitInitializer().createMealsService()

        val call = mealsService.getMealDetails(meal.idMeal)
        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso à Internet")
            }
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if(response.body() != null) {
                    view.listInDetail(response.body()!!.meals.first())
                } else {
                    view.showMessage("Essa refeição não está disponível")
                }
            }
        })
    }

    override fun RandomMeal() {
        val mealsService = RetrofitInitializer().createMealsService()
        val call = mealsService.getRandomMeal()
        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso à Internet")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    view.listInDetail(response.body()!!.meals.first())
                } else {
                    view.showMessage("Essa refeição não está disponível")
                }
            }
        })
    }
}