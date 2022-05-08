package com.example.githubinfo.model

import com.google.gson.annotations.SerializedName


class GitHubUser(

    @field:SerializedName("email")
    var email: String,

    @field:SerializedName("avatar_url")
    var avatar: String,

    @field:SerializedName("following")
    var following: String,

    @field:SerializedName("followers")
    var followers: String,

    @field:SerializedName("name")
    var name: String,

    @field:SerializedName("login")
    var login: String,

    @field:SerializedName("bio")
    var bio: String,

    @field:SerializedName("location")
    var location: String,

    @field:SerializedName("twitter_username")
    var twitter: String,

    @field:SerializedName("created_at")
    var createdAt: String,

    @field:SerializedName("updated_at")
    var updatedAt: String,

    )