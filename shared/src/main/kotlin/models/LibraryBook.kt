package models

import kotlinx.serialization.Serializable

//object LibraryBooks : Table() {
////    val userId = integer("user_id").references(Users.id)
//    val bookId = integer("book_id").references(Books.id)
//    val addedAt = datetime("added_at")
//    val updatedAt = datetime("updated_at")
//    val status = enumerationByName("status", 50, LibraryBookStatus::class) // Using enum for status
//    val isFavorite = bool("is_favorite")
//
//    override val primaryKey = PrimaryKey(bookId) // Primary key for LibraryBooks
//}


@Serializable
data class LibraryBook(
    val bookId: Int,
    val addedAt: String,
    val updatedAt: String,
    val status: LibraryBookStatus,
    val isFavorite: Boolean
)

enum class LibraryBookStatus {
    TO_READ,
    READING,
    READ
}
