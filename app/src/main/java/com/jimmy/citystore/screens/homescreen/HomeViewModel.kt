package com.jimmy.citystore.screens.homescreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    fun updateRoute(route: String,onUpdate: () -> Unit={}) {
        _homeUiState.value = _homeUiState.value.copy(route = route, isNavigating = true)
        onUpdate()
    }
    fun resetHome(){
        _homeUiState.value = HomeUiState()
    }

}
