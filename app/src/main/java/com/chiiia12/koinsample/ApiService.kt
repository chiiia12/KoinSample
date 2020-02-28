package com.chiiia12.koinsample

import retrofit2.Call
import retrofit2.http.GET

//http://dummy.restapiexample.com
interface ApiService {
    @GET("/api/v1/employees")
    fun getData(): Call<Any>
}