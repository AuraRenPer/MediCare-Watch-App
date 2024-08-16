package com.example.myfirstwearapp

import com.example.myfirstwearapp.data.Medication

sealed class ScreenBuena {
    object MainScreen : ScreenBuena()
    data class AlertScreen(val item: Medication) : ScreenBuena()
    data class NextDoseScreen(val timeUntilNextDose: String) : ScreenBuena()
}
