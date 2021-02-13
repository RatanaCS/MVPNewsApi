package com.sumuzu.newsapimvp.network

import com.sumuzu.newsapimvp.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

//TODO 4
interface NewsService {

    @GET("everything?q=olahraga&from=2021-01-10&sortBy=publishedAt&apiKey=09aabdb7aaa1465da0c96ae8a0d16c4a")
    fun getData(): Call<ResponseServer>


}