package com.jimmy.citystore.screens.kids

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class KidsViewModel @Inject constructor() : ViewModel() {
    private val _kidsUiState = MutableStateFlow(KidsUiState())
    open val kidsUiState = _kidsUiState.asStateFlow()
    fun onImportedClick() {
        _kidsUiState.value =
            _kidsUiState.value.copy(isImportedSelected = true, isNationalSelected = false)

    }
    fun onNationalClick() {
        _kidsUiState.value =
            _kidsUiState.value.copy(isImportedSelected = false, isNationalSelected = true)
    }
    fun onSizeClick(size: Size) {
        // Indicate loading
        _kidsUiState.value = _kidsUiState.value.copy(isSizeLoading = true)

        viewModelScope.launch {
            delay(800) // Simulated delay (adjust as needed)
            _kidsUiState.value =
                _kidsUiState.value.copy(selectedSize = size, isSizeLoading = false)
        }

    }
    fun updateGarmentItem(garmentItem: GarmentItem) {
        _kidsUiState.value = _kidsUiState.value.copy(garmentItem = garmentItem)

    }

}