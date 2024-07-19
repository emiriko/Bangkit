package com.alvaro.jetcoffee.model

import com.alvaro.jetcoffee.R

data class Menu(
    val image: Int,
    val title: String,
    val price: String,
)

val menuList = listOf(
    Menu(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menu(R.drawable.menu2, "Pumpkin Spice Latte", "Rp 18.000"),
    Menu(R.drawable.menu3, "Light Cappuccino", "Rp 20.000"),
    Menu(R.drawable.menu4, "Choco Creamy Latte", "Rp 16.000"),
)

val bestSellerMenuList = menuList.shuffled()