package com.example.otushomeworkapp.films

import com.example.otushomeworkapp.film.Film
import com.example.otushomeworkapp.network.KtorClient
import com.example.otushomeworkapp.network.NetworkLayer
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FilmsViewModel() {
    data class FilmModel(
        var items: MutableList<Film> = mutableListOf(),
        var hasNextPage: Boolean = true,
        var currentPage: Int = 1
    )

    private val layer = NetworkLayer()
    private var model = FilmModel()

    suspend fun fetchAllFilms(completion: (FilmModel) -> Unit) {
        layer.getFilms(model.currentPage, "films") {
            for (film in (it.results ?: emptyList())) {
                model.items.add(film)
                model.hasNextPage = (it.next != null)
                model.currentPage += 1
            }

            completion(model)
        }
    }
}