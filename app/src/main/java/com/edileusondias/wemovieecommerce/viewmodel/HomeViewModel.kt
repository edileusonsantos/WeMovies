package com.edileusondias.wemovieecommerce.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edileusondias.wemovieecommerce.model.ProductsList
import com.edileusondias.wemovieecommerce.service.MoviesService
import com.edileusondias.wemovieecommerce.service.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _productsListLiveData = MutableLiveData<ProductsList>()
    val productsListLiveData: LiveData<ProductsList> = _productsListLiveData

    init {
        getData()
    }

    private fun getData(){
        val endpoint = NetworkUtils.getRetrofitInstance().create(MoviesService::class.java)

        val callback = endpoint.getMovies()

        callback.enqueue(object : Callback<ProductsList> {
            override fun onFailure(call: Call<ProductsList>, throwable: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ProductsList>, response: Response<ProductsList>) {
                _productsListLiveData.apply {
                    value = response.body()
                }
            }
        })

    }
}