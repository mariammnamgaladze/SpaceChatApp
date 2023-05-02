package com.space.spacechatapp.presentation.chat.viewmodels

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _themeLiveData = MutableLiveData<Int>()
    val themeLiveData: LiveData<Int>
        get() = _themeLiveData

    private val _backgroundLiveData = MutableLiveData<Int>()
    val backgroundLiveData: LiveData<Int>
        get() = _backgroundLiveData

    fun setTheme(isChecked: Boolean, theme: Int) {
        if (isChecked) {
            _themeLiveData.postValue(theme)
        }
    }

    fun setBackground(isChecked: Boolean, background: Int) {
        if (isChecked) {
            _backgroundLiveData.postValue(background)
        }
    }

    fun setDayNightMode(isNightModeOn: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (isNightModeOn) {
                _themeLiveData.value?.let {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    return@let it
                } ?: AppCompatDelegate.MODE_NIGHT_YES
            } else {
                _themeLiveData.value?.let {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    return@let it
                } ?: AppCompatDelegate.MODE_NIGHT_NO
            }
        )

    }
}
