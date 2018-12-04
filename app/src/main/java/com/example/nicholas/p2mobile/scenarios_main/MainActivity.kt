package com.example.nicholas.p2mobile.scenarios_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.nicholas.p2mobile.R
import com.example.nicholas.p2mobile.entities.Meal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()
    }

    override fun showList(meals: List<Meal>) {

        val adapter = MealAdapter(this, meals)

        /*adapter.setOnItemClickListener { position ->
            showLoading()
            val presenter : MainContract.Presenter = MainPresenter(this)
            presenter.onClickMeal(meals[position])

        }*/

        rvMeals.adapter = adapter
        rvMeals.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }
}
