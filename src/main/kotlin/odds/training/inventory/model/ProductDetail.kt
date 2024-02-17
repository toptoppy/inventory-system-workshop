package odds.training.inventory.model

import org.springframework.context.annotation.Description

data class ProductDetail(
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int
)