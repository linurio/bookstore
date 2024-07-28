package models

import kotlinx.serialization.Serializable

//object BookAuthorLinks : Table() {
//    val bookId = integer("book_id").references(Books.id)
//    val authorId = integer("author_id").references(Authors.id)
//
//    override val primaryKey = PrimaryKey(bookId, authorId)
//}

@Serializable
data class BookAuthor(
    val bookId: Int,
    val authorId: Int
)