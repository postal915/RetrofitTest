package com.example.mdtp.stevdza.repository

import com.example.mdtp.stevdza.api.RetrofitInstance
import com.example.mdtp.stevdza.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}