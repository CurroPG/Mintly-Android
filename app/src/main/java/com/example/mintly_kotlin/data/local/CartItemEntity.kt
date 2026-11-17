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
            id = this.id,
            name = this.name,
            set = this.set,
            price = this.price,
            oldPrice = this.oldPrice,
            image = this.image,
            category = this.category
        ),
        quantity = this.quantity
    )
}

fun CartItem.toEntity(): CartItemEntity {
    return CartItemEntity(
        id = this.product.id,
        name = this.product.name,
        set = this.product.set,
        price = this.product.price,
        oldPrice = this.product.oldPrice,
        image = this.product.image,
        category = this.product.category,
        quantity = this.quantity
    )
}