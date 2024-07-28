package models

import kotlinx.serialization.Serializable

//object Genres : IntIdTable() {
//    val title = varchar("title", 255)
//    val description = text("description")
//}

@Serializable
data class Genre(
    val id: Int,
    val title: String,
    val description: String,
)

