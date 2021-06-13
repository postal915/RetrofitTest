package com.example.mdtp.stevdza.repository

import com.example.mdtp.stevdza.api.RetrofitInstance
import com.example.mdtp.stevdza.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}