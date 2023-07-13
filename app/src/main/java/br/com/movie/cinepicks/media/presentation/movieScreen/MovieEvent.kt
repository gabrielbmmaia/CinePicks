package br.com.movie.cinepicks.media.presentation.movieScreen

sealed class MovieEvent {
    object OnLoadPopularList : MovieEvent()
    object OnLoadTopRatedList : MovieEvent()
}
