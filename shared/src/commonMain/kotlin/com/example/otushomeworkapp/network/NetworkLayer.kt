package com.example.otushomeworkapp.network

import com.example.otushomeworkapp.film.Film
import com.example.otushomeworkapp.films.Films
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NetworkLayer {
    private val client = KtorClient()
    private val job = Job()
    private var scope = CoroutineScope(Dispatchers.Default + job)

    suspend fun getFilms(pageNumber: Int, sectionName: String, completion: (Films) -> Unit) {
        scope.launch {
            val films = client.getFilms(pageNumber, sectionName)
            completion(films)
        }
    }

    suspend fun getFilm(urlString: String, completion: (Film) -> Unit) {
        scope.launch {
            val film = client.getFilm(urlString)
            completion(film)
        }
    }
}