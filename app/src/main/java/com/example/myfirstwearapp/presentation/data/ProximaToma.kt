package com.example.myfirstwearapp.data

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class ProximaToma(
    val fecha: String, // Este campo puede ser usado para crear el LocalDateTime
    val hora: Int,
    val minuto: Int
) {
    fun toLocalDateTime(): LocalDateTime {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val dateTime = LocalDateTime.parse(fecha, formatter)
        return dateTime.withHour(hora).withMinute(minuto)
    }
}
