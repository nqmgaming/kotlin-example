package com.nqmgaming.kotlin.lab6.cinema.domain.entities.movie

data class Movie(
    val title: String = "",
    val genre: String = "",
    val rating: Float = 0.0f,
    val releaseDate: String = "",
    val duration: Int = 0,
    val director: String = "",
    val cast: List<String> = emptyList(),
    val synopsis: String = "",
    val poster: String = ""
)

fun Movie.getListMovies(): List<Movie> {
    return listOf(
        Movie(
            title = "Boy Kills World",
            genre = "Action",
            rating = 6.5f,
            releaseDate = "22 April 2024",
            duration = 111,
            director = "Moritz Bleibtreu",
            cast = listOf("Luna Wedler", "Moritz Bleibtreu", "Jannis Niewöhner"),
            synopsis = "A teenager's adventures as a bounty hunter take an unexpected twist.",
            poster = "https://img.vipstream.tv/xxrz/250x400/397/ba/42/ba42f11eaec96fb5a3d69dd6e9d82fac/ba42f11eaec96fb5a3d69dd6e9d82fac.jpg"
        ),
        Movie(
            title = "The Batman",
            genre = "Action",
            rating = 8.0f,
            releaseDate = "4 March 2022",
            duration = 176,
            director = "Matt Reeves",
            cast = listOf("Robert Pattinson", "Zoë Kravitz", "Paul Dano"),
            synopsis = "In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.",
            poster = "https://img.vipstream.tv/xxrz/250x400/397/21/2d/212d2d95b9d515504a4de227d49a769f/212d2d95b9d515504a4de227d49a769f.jpg"
        ),
        Movie(
            title = "The Flash",
            genre = "Action",
            rating = 7.3f,
            releaseDate = "4 November 2022",
            duration = 150,
            director = "Andy Muschietti",
            cast = listOf("Ezra Miller", "Ben Affleck", "Michael Keaton"),
            synopsis = "The Flash travels back in time to prevent",
            poster = "https://img.vipstream.tv/xxrz/250x400/397/f7/97/f7975e92348f8055ee359ea5218d1aa5/f7975e92348f8055ee359ea5218d1aa5.jpg"
        ),
        Movie(
            title = "The Northman",
            genre = "Action",
            rating = 7.5f,
            releaseDate = "22 April 2022",
            duration = 136,
            director = "Robert Eggers",
            cast = listOf("Anya Taylor-Joy", "Alexander Skarsgård", "Nicole Kidman"),
            synopsis = "Viking revenge saga set in Iceland at the turn of the 10th century.",
            poster = "https://img.vipstream.tv/xxrz/250x400/397/fd/93/fd93f03729505c53f07f9680662c8f27/fd93f03729505c53f07f9680662c8f27.jpg"
        ),
        Movie(
            title = "The Unbearable Weight of Massive Talent",
            genre = "Action",
            rating = 7.0f,
            releaseDate = "22 April 2022",
            duration = 124,
            director = "Tom Gormican",
            cast = listOf("Nicolas Cage", "Pedro Pascal", "Neil Patrick Harris"),
            synopsis = "A cash-strapped Nicolas Cage agrees to make a paid appearance at a billionaire super fan's birthday party, but is really an informant for the CIA since the billionaire fan is a drug kingpin and gets cast in a Tarantino movie.",
            poster = "https://img.vipstream.tv/xxrz/250x400/397/43/6f/436ff82d2fecf88364ec3dbe9f18d59f/436ff82d2fecf88364ec3dbe9f18d59f.jpg"
        ),
    )
}
