package com.wade.stylish.male

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class VegetableViewModel : ViewModel() {



    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */



    val vegetable :List<String> = listOf("花椰菜","青椒","苦瓜","菠菜","馬鈴薯")


    fun displayPropertyDetails(string: String) {
        _navigateToSelectedProperty.value = string
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
    private val _navigateToSelectedProperty = MutableLiveData<String>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedProperty: LiveData<String>
        get() = _navigateToSelectedProperty




    var paging :Int? = null



    /**
     * Sets the value of the response LiveData to the Mars API status or the successful number of
     * Mars properties retrieved.
     */




}