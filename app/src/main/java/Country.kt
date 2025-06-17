package com.example.countrylistapp // Replace with your package name

data class Country(
    val capital: String,
    val code: String,
    val name: String,
    val region: String
    // You can add 'currency' and 'flag' if you plan to use them later
    // val currency: Currency,
    // val flag: String,
    // val language: Language,
    // val demonym: String
)

// If you decide to include currency and language, define these data classes too:
// data class Currency(
//    val code: String,
//    val name: String,
//    val symbol: String
// )
//
// data class Language(
//    val code: String,
//    val name: String
// )