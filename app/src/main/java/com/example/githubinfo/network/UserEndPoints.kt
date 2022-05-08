package com.example.githubinfo.network

import com.example.githubinfo.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserEndPoints {
    @GET("/users/{username}")
    fun getUser(@Path("username") username : String?): Call<GitHubUser?>?
}