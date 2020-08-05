package com.wade.friedfood.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProfileViewModel() : ViewModel() {

//    private val _ProfileData :LiveData<User> = UserManager.ProfileData
//
//    val ProfileData: LiveData<User>
//        get() = _ProfileData

//    val _userData = MutableLiveData<User>()



//    val userData: LiveData<User>
//        get() = _userData



    // status: The internal MutableLiveData that stores the status of the most recent request
//    private val _status = MutableLiveData<LoadApiStatus>()
//
//    val status: LiveData<LoadApiStatus>
//        get() = _status

    // error: The internal MutableLiveData that stores the error of the most recent request
    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    // status for the loading icon of swl
    private val _refreshStatus = MutableLiveData<Boolean>()

    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)








}
