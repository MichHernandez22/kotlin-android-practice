package com.amlh.horoscapp.data

import android.util.Log
import com.amlh.horoscapp.data.network.HoroscopeApiService
import com.amlh.horoscapp.data.network.response.PredictionResponse
import com.amlh.horoscapp.domain.Repository
import com.amlh.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService):Repository {
    override suspend fun getPrediction(sign: String) : PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("amlh", "Ha ocurrido un error ${it.message}") }
        return null
    }
}