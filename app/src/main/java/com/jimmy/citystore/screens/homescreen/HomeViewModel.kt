package com.jimmy.citystore.screens.homescreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    fun updateRoute(route: String) {
        _homeUiState.value = _homeUiState.value.copy(route = route)
    }
    fun resetHome(){
        _homeUiState.value = HomeUiState()
    }
}
