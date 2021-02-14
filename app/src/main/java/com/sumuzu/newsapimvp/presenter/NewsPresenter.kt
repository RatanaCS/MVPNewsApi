package com.sumuzu.newsapimvp.presenter

import com.sumuzu.newsapimvp.model.ArticlesItem
import com.sumuzu.newsapimvp.model.ResponseServer
import com.sumuzu.newsapimvp.network.ConfigRetrofit
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//TODO 7
class NewsPresenter(val news : NewsView) {

    //TODO 5
    fun getNews(){

        ConfigRetrofit.getRetrofit().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                response ->
                if(response.totalResults == 200){
                    news.onSuccess(response.status ?: "", response.articles)
                }
            },{
                e ->
                    news.onError(e.localizedMessage)
            })

//        ConfigRetrofit.getRetrofit().getData().enqueue(object : Callback<ResponseServer>{
//            override fun onResponse(
//                call: Call<ResponseServer>,
//                response: Response<ResponseServer>
//            ) {
//
//                if(response.isSuccessful){
//                    val dataNews = response.body()?.articles
//
//                    if(dataNews?.size ?:0 > 0){
//                        //TODO 8
//                        news.onSuccess(response.message(), dataNews)
//                    }else{
//                        //TODO 8
//                        news.onError("data kosong")
//                    }
//
//                }
//
//            }
//
//            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
//                //TODO 8
//                news.onError(t.localizedMessage)
//            }
//
//        })



    }

}