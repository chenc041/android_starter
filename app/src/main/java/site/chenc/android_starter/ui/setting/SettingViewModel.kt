package site.chenc.android_starter.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import site.chenc.android_starter.http.model.UserResponse
import site.chenc.android_starter.http.repository.userRepository

class SettingViewModel(private val userRepository: userRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "当前进度: 0"
    }

    fun updateText(progress: Int) {
        _text.value = "当前进度 $progress"
    }
    val text: LiveData<String> = _text

    private val _user = MutableLiveData<UserResponse>()
    val user: LiveData<UserResponse> get() = _user

    fun fetchUser(username: String) {
        viewModelScope.launch {
            try {
                val response = userRepository.getUser(username)
                _user.postValue(response)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}