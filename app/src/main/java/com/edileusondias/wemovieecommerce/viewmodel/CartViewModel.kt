package com.edileusondias.wemovieecommerce.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edileusondias.wemovieecommerce.model.Product
import com.edileusondias.wemovieecommerce.model.ProductsList
import com.edileusondias.wemovieecommerce.util.SharedPreferences
import com.google.gson.Gson
import java.util.Arrays.asList

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val _productsListLiveData = MutableLiveData<ProductsList>()
    val productsListLiveData: LiveData<ProductsList> = _productsListLiveData

    init {
        getData()
    }

    fun getData(){
        val shared = SharedPreferences.getAllProducts(getApplication())
        val gson = Gson()
        val products: MutableList<Product> = listOf<Product>().toMutableList()
        if (shared != null) {
            shared.forEach{ entry ->
                products.add(gson.fromJson(entry.value.toString(), Product::class.java))
            }
            _productsListLiveData.apply {
                value= ProductsList(products)
            }
        }
    }
}