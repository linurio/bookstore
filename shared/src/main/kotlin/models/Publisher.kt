package models

import kotlinx.serialization.Serializable

//object Publishers : IntIdTable() {
//    val name = varchar("name", 255)
//    val description = text("description")
//    val country = varchar("country", 100)
//}

@Serializable
data class Publisher(
    val id: Int,
    val name: String,
    val description: String,
    val country: String,
)