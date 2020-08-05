package com.wade.stylish.shopingcart

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.wade.stylish.room.SelectedDatabaseDao

//factory的用途 為額要加進databasedao application

class ShopingCartFactory(
    private val marsProperty: String,
    private val application: Application,
    private  val databaseDao : SelectedDatabaseDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopingCartViewModel::class.java)) {
            return ShopingCartViewModel(marsProperty, databaseDao ,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}