package models

import kotlinx.serialization.Serializable

//object Authors : IntIdTable() {
//    val firstName = varchar("first_name", 255)
//    val lastName = varchar("last_name", 255)
//    val birthDate = date("birth_date")
//    val nationality = varchar("nationality", 100)
//}

@Serializable
data class Author(
    val firstName: String,
    val lastName: String,
    val birthDate: String,
    val nationality: String,

)