package com.example.nicholas.p2mobile.scenarios_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nicholas.p2mobile.R
import com.example.nicholas.p2mobile.entities.Meal
import com.example.nicholas.p2mobile.utils.GlideApp
import kotlinx.android.synthetic.main.meal_item.view.*

class MealAdapter (val context: Context, val meals: List<Meal>)
    : RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, meals[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, meal: Meal, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.mealTitle.text = meal.strMeal

            GlideApp.with(context)
                    .load(meal.strMealThumb)
                    .placeholder(R.drawable.foodplaceholder)
                    .centerCrop()
                    .into(itemView.imgMeals)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }

    }

}