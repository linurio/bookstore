package models

import kotlinx.serialization.Serializable

//object Books : IntIdTable() {
//    val title = varchar("title", 255)
//    val description = text("description")
//    val isbn = varchar("isbn", 13)
//    val year = integer("year")
//    val publisherId = integer("publisher_id").references(Publishers.id)
//    val genreId = integer("genre_id").references(Genres.id)
//    val inStock = bool("in_stock")
//    val language = varchar("language", 50)
//    val rating = integer("rating")
//    val price = decimal("price", 10, 2) // Using BigDecimal
//}

@Serializable
data class Book(
    val id: Int,
    val title: String,
    val description: String,
    val author: BookAuthor,
    val isbn: String,
    val year: Int,
    val publisherId: Int,
    val genreId: Int,
    val inStock: Boolean,
    val language: String,
    val rating: Int,
    val price: Float,
)
