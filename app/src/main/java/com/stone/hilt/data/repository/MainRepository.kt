package com.stone.hilt.data.repository

import com.stone.hilt.data.api.ApiHelper
import com.stone.hilt.data.model.User
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers():Response<List<User>>{
       return apiHelper.getUsers()
    }
}