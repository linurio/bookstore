package com.example.android

data class BookCoverItem(
    val desc: String,
    val imageUrl: String,
)

data class AuthorItem(
    val name: String,
    val imageUrl: String
)

val showcaseItems = listOf(
    BookCoverItem(
        "The Witcher. Baptism of Fire",
        "https://www.orbitbooks.net/wp-content/uploads/2022/07/3-BaptismFire_HC-scaled.jpg",
    ),
    BookCoverItem(
        "1984", "https://m.media-amazon.com/images/I/61f1ytOB-QL._SL1186_.jpg",
    ),
    BookCoverItem(
        "Dune", "https://i.imgur.com/L4eBl4C.jpeg",
    ),
)

val bestsellers = listOf(
    BookCoverItem(
        "Dune", "https://i.imgur.com/L4eBl4C.jpeg",
    ),
    BookCoverItem(
        "Fight club",
        "https://i.imgur.com/qukm7x5.jpeg",
    ),
    BookCoverItem(
        "Lord of the Rings", "https://i.imgur.com/ul54YDF.jpeg",
    ),
    BookCoverItem(
        "Sapiens", "https://i.imgur.com/AbCGzc1.jpeg",
    ),
    BookCoverItem(
        "1984", "https://m.media-amazon.com/images/I/61f1ytOB-QL._SL1186_.jpg",
    ),
    BookCoverItem(
        "The Martian", "https://i.imgur.com/s5rSfuM.jpeg",
    ),
    BookCoverItem(
        "The Shining", "https://i.imgur.com/fM6nkaD.jpeg",
    ),
    BookCoverItem(
        "The Witcher. Blood of elves", "https://i.imgur.com/lccJUc2.jpeg",
    ),
    BookCoverItem(
        "The Witcher. The last wish", "https://i.imgur.com/v7VIVcR.jpeg",
    ),
    BookCoverItem(
        "The Witcher. Sword of destiny", "https://i.imgur.com/fJOnQGF.jpeg",
    ),
    BookCoverItem(
        "The Witcher. The time of contempt", "https://i.imgur.com/5QjwdUg.jpeg",
    ),
    BookCoverItem(
        "The Witcher. The tower of swallows", "https://i.imgur.com/irycgiI.jpeg",
    ),
)

val fantasy = listOf(
    BookCoverItem(
        "Lord of the Rings", "https://i.imgur.com/ul54YDF.jpeg",
    ),
    BookCoverItem(
        "The Shining", "https://i.imgur.com/fM6nkaD.jpeg",
    ),
    BookCoverItem(
        "Dune", "https://i.imgur.com/L4eBl4C.jpeg",
    ),
    BookCoverItem(
        "The Witcher. Blood of elves", "https://i.imgur.com/lccJUc2.jpeg",
    ),
    BookCoverItem(
        "The Witcher. The last wish", "https://i.imgur.com/v7VIVcR.jpeg",
    ),
    BookCoverItem(
        "The Witcher. Sword of destiny", "https://i.imgur.com/fJOnQGF.jpeg",
    ),
    BookCoverItem(
        "The Witcher. The time of contempt", "https://i.imgur.com/5QjwdUg.jpeg",
    ),
    BookCoverItem(
        "The Witcher. The tower of swallows", "https://i.imgur.com/irycgiI.jpeg",
    ),
)

val scifi = listOf(
    BookCoverItem(
        "The Martian", "https://i.imgur.com/s5rSfuM.jpeg",
    ),
    BookCoverItem(
        "Dune", "https://i.imgur.com/L4eBl4C.jpeg",
    ),
    BookCoverItem(
        "Sapiens", "https://i.imgur.com/AbCGzc1.jpeg",
    ),
)

val authors = listOf(
    AuthorItem(
        "Andrzej Sapkowski",
        "https://charmouthtennisclub.org/wp-content/uploads/2021/01/placeholder-400x400.jpg",
    ),
    AuthorItem(
        "J.R.R. Tolkien",
        "https://charmouthtennisclub.org/wp-content/uploads/2021/01/placeholder-400x400.jpg",
    ),
    AuthorItem(
        "Stephen King",
        "https://charmouthtennisclub.org/wp-content/uploads/2021/01/placeholder-400x400.jpg",
    ),
    AuthorItem(
        "J.J.R. Martin",
        "https://charmouthtennisclub.org/wp-content/uploads/2021/01/placeholder-400x400.jpg",
    ),
)

