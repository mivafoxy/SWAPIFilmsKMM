package com.example.otushomeworkapp.film

import com.example.otushomeworkapp.network.KtorClient
import com.example.otushomeworkapp.network.NetworkLayer
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FilmViewModel(urlString: String) {
    private val urlString: String = urlString
    private val layer = NetworkLayer()

    suspend fun fetchFilm(completion: (Film) -> Unit) {
        layer.getFilm(urlString) {
            completion(it)
        }
    }
}