package site.chenc.android_starter.http.api

import retrofit2.http.GET
import retrofit2.http.Path
import site.chenc.android_starter.http.model.UserResponse
import site.chenc.android_starter.http.retrofit

interface GitHubApiService {
    @GET("users/{user}")
    suspend fun getUser(@Path("user") user: String): UserResponse
}

val gitHubApiService = retrofit.create(GitHubApiService::class.java);