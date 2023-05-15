package com.space.chatapp.presentation.chat.activity.viewmodel

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.space.chatapp.R

/**
 * The ActivityViewModel class is a subclass of the Android Architecture Components ViewModel class that provides data and functionality related to the activity's theme and background.
 * It has two live data objects, themeLiveData and backgroundLiveData, that other components can observe to get updates about the current theme and background.
 */
class ActivityViewModel : ViewModel() {

    private val _themeLiveData = MutableLiveData<Int>()
    val themeLiveData: LiveData<Int>
        get() = _themeLiveData

    private val _backgroundLiveData = MutableLiveData<Int>()
    val backgroundLiveData: LiveData<Int>
        get() = _backgroundLiveData

    fun setDayNightMode(isNightModeOn: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (isNightModeOn) {
                _backgroundLiveData.postValue(R.drawable.ic_nigth_to_day_mode)
                _themeLiveData.value?.let {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    return@let it
                } ?: AppCompatDelegate.MODE_NIGHT_YES
            } else {
                _backgroundLiveData.postValue(R.drawable.ic_day_to_night_mode)
                _themeLiveData.value?.let {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    return@let it
                } ?: AppCompatDelegate.MODE_NIGHT_NO
            }
        )
    }
}
