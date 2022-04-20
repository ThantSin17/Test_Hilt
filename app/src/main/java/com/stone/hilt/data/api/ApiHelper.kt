package com.stone.hilt.data.api

import com.stone.hilt.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers():Response<List<User>>
}