package com.example.myfirstwearapp.data

data class Medication(
    val id: String,
    val nombre: String,
    val dosis: String,
    val presentación: String,
    val frecuencia: Frecuencia,  // Asegúrate de que esta propiedad exista
    val proxima_toma: ProximaToma
)
