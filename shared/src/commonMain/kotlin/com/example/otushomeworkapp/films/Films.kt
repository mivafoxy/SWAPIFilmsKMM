package com.example.otushomeworkapp.films

import com.example.otushomeworkapp.film.Film
import kotlinx.serialization.Serializable

@Serializable
data class Films(
    val count: Int?,
    val next: String?,
    val previous: String?,
    var results: ArrayList<Film>?
)