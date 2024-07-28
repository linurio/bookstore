package models

import kotlinx.serialization.Serializable

//object OrderBooks : Table() {
//    val orderId = integer("order_id").references(Orders.id)
//    val bookId = integer("book_id").references(Books.id)
//    val quantity = integer("quantity")
//    val price = decimal("price", 10, 2) // Using BigDecimal
//
//    override val primaryKey = PrimaryKey(orderId, bookId) // Composite key
//}

@Serializable
data class OrderBook(
    val cartId: Int,
    val bookId: Int,
    val quantity: Int,
    val price: Int,
)