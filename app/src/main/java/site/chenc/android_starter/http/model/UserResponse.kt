package site.chenc.android_starter.http.model
import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
    @JsonProperty("login") val login: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("avatar_url") val avatarUrl: String
)