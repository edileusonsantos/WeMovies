package com.edileusondias.wemovieecommerce.service

import com.edileusondias.wemovieecommerce.model.ProductsList
import retrofit2.Call
import retrofit2.http.GET

interface MoviesService {

    @GET("movies")
    fun getMovies(): Call<ProductsList>
}