package com.example.retrofittest.repository

import com.example.retrofittest.api.RetrofitInstance
import com.example.retrofittest.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}