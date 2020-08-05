package com.wade.stylish.shopingcart

import android.app.Application
import android.widget.Toast
import androidx.databinding.InverseMethod
import androidx.lifecycle.*
import com.wade.grilled.MyApplication

import com.wade.stylish.room.SelectedDatabaseDao
import com.wade.stylish.room.SelectedProduct
import kotlinx.coroutines.*

class ShopingCartViewModel(string: String, val database: SelectedDatabaseDao, app: Application) : AndroidViewModel(app) {


    // Internally, we use a MutableLiveData, because we will be updating the List of DataItem
    // with new values
    private val _shopingCartData = MutableLiveData<String>()

    val shopingCartData: LiveData<String>
        get() = _shopingCartData








    val selectedproducts = database.getAllProducts()




    private val _products = MutableLiveData<List<String>>()
    // The external LiveData interface to the property is immutable, so only this class can modify
    val products: LiveData<List<String>>
        get() = _products


    init {
        _shopingCartData.value = string
    }


    @InverseMethod("convertLongToString")
    fun convertStringToLong(value: String): Int {
        return try {
            value.toInt().let {
                when (it) {
                    0 -> 1
                    else -> it
                }
            }
        } catch (e: NumberFormatException) {
            1
        }
    }
    fun convertLongToString(value: Int): String {
        return value.toString()
    }


//    livedata 要用apply設定值
    val input = MutableLiveData<Int>().apply {
        value = 0
    }



    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)



    fun addToCart(){
        var selectedProduct=SelectedProduct()

        _shopingCartData.value?.let{

            selectedProduct.selectTitle = it

        }



        input.value?.let {
            selectedProduct.selectAmount = it
        }



        uiScope.launch {
            val selectproduct = getSameFromDatabase(selectedProduct.selectTitle, selectedProduct.selectColor, selectedProduct.selectSize)

            if (selectproduct != null){
                Toast.makeText(MyApplication.appContext, "原本的數量更改為${selectedProduct.selectAmount}", Toast.LENGTH_SHORT).show()
                selectproduct.selectAmount = selectedProduct.selectAmount
                update(selectproduct)
            }else {
                insert(selectedProduct)
            }
        }

    }


    private suspend fun getSameFromDatabase(title: String, color: String, size: String): SelectedProduct? {
        return withContext(Dispatchers.IO) {
            var selectProduct = database.getSameProduct(title, color, size)
            selectProduct
        }
    }

    private suspend fun delete(selectProduct: SelectedProduct) {
        withContext(Dispatchers.IO) {
            database.delete(selectProduct)
        }
    }


    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }


    private suspend fun update(selectProduct: SelectedProduct) {
        withContext(Dispatchers.IO) {
            database.update(selectProduct)
        }
    }

    private suspend fun insert(selectProduct: SelectedProduct) {
        withContext(Dispatchers.IO) {
            database.insert(selectProduct)
        }
    }







}









/**
 * Call getProperties() on init so we can display status immediately.
 */
