package com.sumuzu.newsapimvp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ConfigRetrofit {

    companion object{

        //TODO 3 inisialisasi retrofit
        fun getRetrofit() : NewsService{
            val retrofitNews = Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            var service : NewsService = retrofitNews.create<NewsService>(NewsService::class.java)

            return service
        }
    }



}