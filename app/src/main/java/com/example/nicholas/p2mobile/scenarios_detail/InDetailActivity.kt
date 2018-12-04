package com.example.nicholas.p2mobile.scenarios_detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nicholas.p2mobile.R
import com.example.nicholas.p2mobile.entities.Meal
import com.example.nicholas.p2mobile.utils.GlideApp
import kotlinx.android.synthetic.main.in_detail_activity.*


class InDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.in_detail_activity)

        if (intent.extras != null) {
            val myData :Meal = intent.getSerializableExtra("meal") as Meal
            mealNameDetailed.text = myData.strMeal
            GlideApp.with(this)
                    .load(myData.strMealThumb)
                    .placeholder(R.drawable.foodplaceholder)
                    .centerCrop()
                    .into(mealPhoto)

            val ingredients = mutableListOf(myData.strIngredient1, myData.strIngredient2, myData.strIngredient3, myData.strIngredient4, myData.strIngredient5,
                    myData.strIngredient6, myData.strIngredient7, myData.strIngredient8, myData.strIngredient9, myData.strIngredient10,
                    myData.strIngredient11, myData.strIngredient12, myData.strIngredient13, myData.strIngredient14, myData.strIngredient15, myData.strIngredient16,
                    myData.strIngredient17, myData.strIngredient18, myData.strIngredient19, myData.strIngredient20)
            val quantities = mutableListOf(myData.strMeasure1, myData.strMeasure2, myData.strMeasure3, myData.strMeasure4, myData.strMeasure5,
                    myData.strMeasure6, myData.strMeasure7, myData.strMeasure8, myData.strMeasure9, myData.strMeasure10,
                    myData.strMeasure11, myData.strMeasure12, myData.strMeasure13, myData.strMeasure14, myData.strMeasure15, myData.strMeasure16, myData.strMeasure17,
                    myData.strMeasure18, myData.strMeasure19, myData.strMeasure20)

            val ingredientsIterator = ingredients.listIterator()
            val quantityIterator = quantities.listIterator()        // Iterador checa se tem um próx elemento ou não a ser chamado

            val stringIngredient = StringBuilder()
            val stringQuantity = StringBuilder()
            val stringCategory = StringBuilder()
            val stringArea = StringBuilder()

            stringCategory.append("Category: ").append(myData.strCategory)
            stringArea.append("Food type: ").append(myData.strArea)

            for(item in ingredientsIterator){
                if(!item.isNullOrBlank()){                          // Se o ingrediente for nulo ou do tipo ''
                    stringIngredient.append(item).append('\n').append('\n')
                }
            }
            for(item in quantityIterator){
                if(!item.isNullOrBlank()){
                    stringQuantity.append(item).append('\n').append('\n')
                }
            }

            ingredient.text = stringIngredient
            quantity.text = stringQuantity

            Category.text = stringCategory
            Area.text = stringArea
            Instructions.text = myData.strInstructions
        }
    }
}
