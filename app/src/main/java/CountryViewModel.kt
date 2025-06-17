package com.example.countrylistapp // Replace with your package name

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CountryViewModel(private val repository: CountryRepository) : ViewModel() {

    val countries: LiveData<List<Country>> = repository.countries
    val error: LiveData<String> = repository.error

    init {
        loadCountries()
    }

    fun loadCountries() {
        viewModelScope.launch {
            repository.fetchCountries()
        }
    }
}