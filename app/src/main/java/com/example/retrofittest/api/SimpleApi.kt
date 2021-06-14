package com.example.retrofittest.api

import com.example.retrofittest.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>
}