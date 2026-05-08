package com.rido.akupengenimo.data.remote


class HeroRepository(private val apiService: DraftApiService) {
    suspend fun fetchHeroes(): Result<List<HeroDraft>> {
        return try {
            val response = apiService.getDraftHeroes()
            Result.success(response)
        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}