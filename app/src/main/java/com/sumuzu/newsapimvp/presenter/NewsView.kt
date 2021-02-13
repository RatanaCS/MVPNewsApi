package com.sumuzu.newsapimvp.presenter

import com.sumuzu.newsapimvp.model.ArticlesItem

interface NewsView {

    //TODO 6
    fun onSuccess(msg : String, article : List<ArticlesItem?>?)
    fun onError (msg : String)

}