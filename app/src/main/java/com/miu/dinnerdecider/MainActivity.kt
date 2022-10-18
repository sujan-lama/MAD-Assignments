package com.miu.dinnerdecider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFoodBtn.setOnClickListener {
            val newFood = addNewFoodEditText.text.toString()
            foodList.add(newFood)
            addNewFoodEditText.text.clear()
            println(foodList)
        }
        decideBtn.setOnClickListener {
            val random = java.util.Random()
            val randomFood = random.nextInt(foodList.count())
            dinnerText.text = foodList[randomFood]
        }
    }
}