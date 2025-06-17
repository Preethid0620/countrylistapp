package com.example.countrylistapp // Replace with your package name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Response

class CountryRepository(private val apiService: ApiService) {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    suspend fun fetchCountries() {
        try {
            val response = apiService.getCountries()
            if (response.isSuccessful) {
                _countries.postValue(response.body())
            } else {
                _error.postValue("Error: ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            _error.postValue("Exception: ${e.message}")
        }
    }
}