package site.chenc.android_starter.http.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import site.chenc.android_starter.http.api.GitHubApiService
import site.chenc.android_starter.http.model.UserResponse

class UserRepository(private val gitHubApiService: GitHubApiService) {
    suspend fun getUser(username: String): UserResponse {
        return withContext(Dispatchers.IO) {
            gitHubApiService.getUser(username)
        }
    }

}