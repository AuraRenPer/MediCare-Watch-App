package com.example.myfirstwearapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstwearapp.data.Medication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class MedicationViewModel : ViewModel() {
    private val client = OkHttpClient()

    private val _medications = mutableStateOf<List<Medication>>(emptyList())
    val medications: State<List<Medication>> get() = _medications

    init {
        fetchMedications()
    }

    private fun fetchMedications() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                val request = Request.Builder()
                    .url("https://medicare-api-khaki.vercel.app/api/medicamentos")
                    .build()
                client.newCall(request).execute().body?.string()
            }
            response?.let {
                val listType = object : TypeToken<List<Medication>>() {}.type
                val medicationsList: List<Medication> = Gson().fromJson(it, listType)
                _medications.value = medicationsList
            }
        }
    }

    fun onConfirmMedication(context: Context, medication: Medication) {
        // Aquí puedes manejar la lógica de confirmar la toma del medicamento.
        // Por ejemplo, podrías registrar la toma, actualizar la próxima dosis, etc.
        // En este caso, simplemente imprimimos un mensaje de confirmación.
        println("Medicación confirmada: ${medication.nombre}")
    }
}
