package com.rido.akupengenimo.data.remote


class HeroRepository(private val apiService: DraftApiService) {
    suspend fun fetchHeroes(): Result<List<HeroDraft>> {
        return try {
            val response = apiService.getDraftHeroes()
            Result.success(response)
        } catch (e: Exception) {
            // Ini try-catch buat nangkep kalau internet mati (syarat LKP)
            Result.failure(e)
        }
    }
}