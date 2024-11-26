package site.chenc.android_starter.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "当前进度: 0"
    }

    fun updateText(progress: Int) {
        _text.value = "当前进度 $progress"
    }
    val text: LiveData<String> = _text
}