package odds.training.inventory.entity

import org.bson.types.ObjectId
import org.springframework.context.annotation.Description
import org.springframework.data.mongodb.core.mapping.Document

@Document("product")
data class ProductEntity(
    val id: ObjectId,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int
)
