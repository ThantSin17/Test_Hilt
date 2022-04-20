package com.stone.hilt.data.api

import com.stone.hilt.data.model.User
import retrofit2.Response

import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUser(): Response<List<User>>
}