package com.miu.mdp.shopping

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.model.Product
import com.miu.mdp.products.ProductActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val USERNAME = "userName"

        fun newInstance(context: Context, userName: String): Intent {
            val intent = Intent(context, ShoppingCategoryActivity::class.java)
            intent.putExtra(USERNAME, userName)
            return intent
        }
    }

    private val electronicProductList = arrayListOf(
        Product(
            itemId = "1",
            title = "Samsung Galaxy S21",
            price = 1000.0,
            color = "Black",
            desc = "Samsung Galaxy S21 is the latest smartphone from Samsung. It has a 6.2-inch display, 8GB RAM, 128GB storage, and a 4000mAh battery. It has a 12MP + 64MP + 12MP triple rear camera and a 10MP front camera. It runs on Android 11 and is powered by a 4000mAh battery.",
            image = R.drawable.s21
        ),
        Product(
            itemId = "2",
            title = "Apple iPhone 12",
            price = 800.0,
            color = "Black",
            desc = "Apple iPhone 12 is the latest smartphone from Apple. It has a 6.1-inch display, 4GB RAM, 64GB storage, and a 2815mAh battery. It has a 12MP + 12MP + 12MP triple rear camera and a 12MP front camera. It runs on iOS 14 and is powered by a 2815mAh battery.",
            image = R.drawable.iphone12
        ),
        Product(
            itemId = "3",
            title = "Google Pixel 5",
            price = 700.0,
            color = "Black",
            desc = "Google Pixel 5 is the latest smartphone from Google. It has a 6.0-inch display, 8GB RAM, 128GB storage, and a 4080mAh battery. It has a 12.2MP + 16MP + 12.2MP triple rear camera and a 8MP front camera. It runs on Android 11 and is powered by a 4080mAh battery.",
            image = R.drawable.pixel5
        ),
        Product(
            itemId = "4",
            title = "OnePlus 8T",
            price = 600.0,
            color = "Black",
            desc = "OnePlus 8T is the latest smartphone from OnePlus. It has a 6.55-inch display, 12GB RAM, 256GB storage, and a 4500mAh battery. It has a 48MP + 16MP + 5MP triple rear camera and a 16MP front camera. It runs on Android 11 and is powered by a 4500mAh battery.",
            image = R.drawable.oneplus8t
        ),
        Product(
            itemId = "5",
            title = "Samsung Galaxy S20 FE",
            price = 500.0,
            color = "Black",
            desc = "Samsung Galaxy S20 FE is the latest smartphone from Samsung. It has a 6.5-inch display, 8GB RAM, 128GB storage, and a 4500mAh battery. It has a 12MP + 12MP + 8MP triple rear camera and a 32MP front camera. It runs on Android 11 and is powered by a 4500mAh battery.",
            image = R.drawable.s20fe
        ),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        val userName = intent.getStringExtra(USERNAME)
        welcome_text.text = "Welcome $userName"

        setListener()
    }

    private fun setListener() {
        category_electronics.setOnClickListener(this)
        category_electronics_text.setOnClickListener(this)
        category_beauty.setOnClickListener(this)
        category_beauty_text.setOnClickListener(this)
        category_clothing.setOnClickListener(this)
        category_clothing_text.setOnClickListener(this)
        category_food.setOnClickListener(this)
        category_food_text.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            category_electronics, category_electronics_text -> {
                startActivity(
                    ProductActivity.newInstance(
                        this,
                        productList = electronicProductList
                    )
                )
            }
            category_clothing, category_clothing_text -> {
                Toast.makeText(
                    this,
                    "You have chosen the Clothing category of shopping”",
                    Toast.LENGTH_SHORT
                ).show()
            }
            category_beauty, category_beauty_text -> {
                Toast.makeText(
                    this,
                    "You have chosen the Beauty category of shopping”",
                    Toast.LENGTH_SHORT
                ).show()
            }
            category_food, category_food_text -> {
                Toast.makeText(
                    this,
                    "You have chosen the Food category of shopping”",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}