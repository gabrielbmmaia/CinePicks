package br.com.movie.cinepicks.media.presentation.movieScreen

sealed class MovieEvent {
    object OnLoadPopularList : MovieEvent()
    object OnLoadTopRatedList : MovieEvent()
    object OnLoadUpcomingList : MovieEvent()
    object OnLoadTheaterList : MovieEvent()
}
