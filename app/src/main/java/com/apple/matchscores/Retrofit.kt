package com.apple.matchscores

import com.apple.matchscores.data.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val TOKEN = "lk6TaJilqX2iJ7kCp79MhtJlVRtonJ7KdCEfsQPVKH3kOK71PMHIldBKUUkU"
private const val BASE_URL = "https://api.sportmonks.com/v3/football/"
private const val SUB_URL = "fixtures?api_token=$TOKEN"

private val retrofit = Retrofit.Builder()
	.addConverterFactory(GsonConverterFactory.create())
	.baseUrl(BASE_URL)
	.build()
interface ApiService{
	@GET(SUB_URL)
	suspend fun fetchData(): Api
}
object Api{
	val retrofitService :ApiService by lazy {
	    retrofit.create(ApiService ::class.java)
	}
}