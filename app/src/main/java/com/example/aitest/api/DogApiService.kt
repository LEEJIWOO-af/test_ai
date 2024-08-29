package com.example.aitest.api

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): DogImageResponse

    companion object {
        private const val BASE_URL = "https://dog.ceo/api/"

        fun create(): DogApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DogApiService::class.java)
        }
    }
}

data class DogImageResponse(
    val message: String,
    val status: String
)