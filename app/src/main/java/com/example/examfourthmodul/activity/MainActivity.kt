package com.example.examfourthmodul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examfourthmodul.R
import com.example.examfourthmodul.adapter.CustomAdapter
import com.example.examfourthmodul.model.Food

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)

        refreshAdapter()
    }

    private fun refreshAdapter() {
        val foods = prepareFoodList()
        customAdapter = CustomAdapter(foods)
        recyclerView.adapter = customAdapter

        loadingMoreFoods(foods)

    }


    private fun loadingMoreFoods(foods: ArrayList<Food>) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                val totalItemCount = layoutManager.itemCount
                val lastVisible = layoutManager.findLastVisibleItemPosition()
                val endHasBeenReached = lastVisible + 3 >= totalItemCount
                if (totalItemCount > 0 && endHasBeenReached) {
                    customAdapter.addFoodList(foods)
                    customAdapter.notifyDataSetChanged()
                }
            }
        })
    }


    private fun prepareFoodList(): ArrayList<Food> {
        val foods: ArrayList<Food> = ArrayList()
        for (i in 1..2) {
            foods.add(Food(R.drawable.deli, "Deli Turbo", R.drawable.ic_star, "Deli", "London"))
            foods.add(
                Food(
                    R.drawable.diner,
                    "Diner SteakHouse",
                    R.drawable.ic_star_border,
                    "Osh",
                    "Seatle"
                )
            )
            foods.add(Food(R.drawable.fire, "Fire Hyper", R.drawable.ic_star, "Cabob", "Jizzax"))
            foods.add(
                Food(
                    R.drawable.restaurent,
                    "Restaurant",
                    R.drawable.ic_star,
                    "Brunch",
                    "Parij"
                )
            )
            foods.add(
                Food(
                    R.drawable.deli2,
                    "Deli Cious",
                    R.drawable.ic_star_half,
                    "Manoco",
                    "Amsterdam"
                )
            )
            foods.add(
                Food(
                    R.drawable.diner2,
                    "Diner SteakHouse",
                    R.drawable.ic_star_border,
                    "Congo",
                    "Dubai"
                )
            )
            foods.add(
                Food(
                    R.drawable.fire2,
                    "Fire Hyper",
                    R.drawable.ic_star_half,
                    "Brunch",
                    "Congo"
                )
            )
            foods.add(
                Food(
                    R.drawable.restaurent3,
                    "Restaurant",
                    R.drawable.ic_star,
                    "Italian",
                    "California"
                )
            )
            foods.add(
                Food(
                    R.drawable.deli3,
                    "Deli Turbo",
                    R.drawable.ic_star_half,
                    "Deli",
                    "Minsk"
                )
            )
            foods.add(
                Food(
                    R.drawable.diner3,
                    "Diner SteakHouse",
                    R.drawable.ic_star_border,
                    "Lavash",
                    "Gaga"
                )
            )
        }
        return foods
    }

}