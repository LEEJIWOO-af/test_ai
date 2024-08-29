package com.example.aitest.repository
import com.example.aitest.api.DogApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DogRepository(private val apiService: DogApiService) {
    fun getRandomDogImage(): Flow<String> = flow {
        val response = apiService.getRandomDogImage()
        if (response.status == "success") {
            emit(response.message)
        } else {
            throw Exception("Failed to fetch dog image")
        }
    }
}