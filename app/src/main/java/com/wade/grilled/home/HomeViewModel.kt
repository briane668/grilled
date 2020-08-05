package com.wade.stylish.home

import android.util.Log
import androidx.lifecycle.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

enum class StylishApiStatu { LOADING, ERROR, DONE }
/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class HomeViewModel() : ViewModel() {


    // Internally, we use a MutableLiveData, because we will be updating the List of DataItem
    // with new values




    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Call getProperties() on init so we can display status immediately.
     */

    /**
     * TODO(08)
     * Gets hots property information from the Marketing Hots API Retrofit service and
     * updates the [Property Object]. The Retrofit service
     * returns a coroutine Deferred, which we await to get the result of the transaction.
     */


    /**
     * TODO(08)
     * Gets hots property information from the Marketing Hots API Retrofit service and
     * updates the [Property Object]. The Retrofit service
     * returns a coroutine Deferred, which we await to get the result of the transaction.
     */

}
