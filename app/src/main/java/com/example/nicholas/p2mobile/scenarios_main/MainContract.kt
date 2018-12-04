package com.example.nicholas.p2mobile.scenarios_main

import com.example.nicholas.p2mobile.entities.Meal


interface MainContract {

        interface View{
            fun showMessage(msg: String)
            fun showList(articles: List<Meal>)
            fun showLoading()
            fun hideLoading()
        }

        interface Presenter {
            fun onLoadList()
        }

}