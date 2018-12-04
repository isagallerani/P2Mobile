package com.example.nicholas.p2mobile.scenarios_main

import com.example.nicholas.p2mobile.entities.Meal


interface MainContract {

        interface View{
            fun showMessage(msg: String)
            fun showList(meals: List<Meal>)
            fun showLoading()
            fun hideLoading()
            fun listInDetail(meal: Meal)
        }

        interface Presenter {
            fun onLoadList()
            fun onClickMeal(meal: Meal)
            fun RandomMeal()
        }

}