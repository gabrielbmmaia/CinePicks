package br.com.movie.cinepicks.media.presentation.movieScreen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.movie.cinepicks.media.domain.repository.MediaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MediaRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MovieState())
    val state = _state.asStateFlow()

    fun onEvent(event: MovieEvent) {
        when (event) {
            MovieEvent.OnLoadPopularList -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(popularList = repository.getPopularMovies())
                    }
                }
            }
        }
    }
}