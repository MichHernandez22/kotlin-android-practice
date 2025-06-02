package com.amlh.horoscapp.domain

import com.amlh.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String):PredictionModel?
}