package com.example.mintly_kotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mintly_kotlin.data.CartItem
import com.example.mintly_kotlin.data.Product

@Entity(tableName= "cartItems")
data class CartItemEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val set: String,
    val price: Double,
    val oldPrice: Double? = null,
    val image: Int,
    val category: Int? = null,
    val quantity: Int
)

fun CartItemEntity.toModel(): CartItem {
    return CartItem( product =
        Product(
            id = id,
            name = name,
            set = set,
            price = price,
            oldPrice = oldPrice,
            image = image,
            category = category
        ),
        quantity = quantity
    )
}

fun CartItem.toEntity(): CartItemEntity {
    return CartItemEntity(
        id = product.id,
        name = product.name,
        set = product.set,
        price = product.price,
        oldPrice = product.oldPrice,
        image = product.image,
        category = product.category,
        quantity = quantity
    )
}