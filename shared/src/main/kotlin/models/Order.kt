package models

import kotlinx.serialization.Serializable

//object Orders : IntIdTable() {
////    val userId = integer("user_id").references(Users.id)
//    val totalPrice = decimal("total_price", 10, 2)
//    val createdAt = datetime("created_at")
//    val updatedAt = datetime("updated_at")
//    val status = varchar("status", 50).nullable()
//}

@Serializable
data class Order(
    val id: Int,
    val userId: Int,
    val totalPrice: Int,
//    val items: List<OrderBook>,
    val createdAt: String,
    val updatedAt: String,
)