package com.example.otushomeworkapp.film

import kotlinx.serialization.Serializable

@Serializable
data class Film(
    val title: String,
    val episode_id: Int,
    val opening_crawl: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val species: ArrayList<String>,
    val starships: ArrayList<String>,
    val vehicles: ArrayList<String>,
    val characters: ArrayList<String>,
    val planets: ArrayList<String>,
    val url: String,
    val created: String,
    val edited: String
)