package com.amlh.horoscapp.data.network.response

import com.amlh.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
){
    fun toDomain():PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}