package com.rido.akupengenimo.data.remote

import retrofit2.http.GET

interface DraftApiService {

    @GET("https://gist.githubusercontent.com/ridororo/bc5386eee7d07359f623c712d83c2847/raw/a0dd3b60d4696e68fa63a1890cb936667facfcee/gistfile1.txt")
    suspend fun getDraftHeroes(): List<HeroDraft>
}