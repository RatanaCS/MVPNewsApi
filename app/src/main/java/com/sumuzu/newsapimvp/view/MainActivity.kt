package com.sumuzu.newsapimvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sumuzu.newsapimvp.R
import com.sumuzu.newsapimvp.model.ArticlesItem
import com.sumuzu.newsapimvp.presenter.NewsPresenter
import com.sumuzu.newsapimvp.presenter.NewsView

class MainActivity : AppCompatActivity(), NewsView {

    //TODO 9 deklarasi variable presenter
    private var presenter : NewsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO 10 init presenter
        presenter = NewsPresenter(this)
        presenter?.getNews()
    }

    override fun onSuccess(msg: String, article: List<ArticlesItem?>?) {
        //TODO 11 bind data ke recyclerview
        for(i in article?.indices ?: 0..1){
            Log.d("data News", article?.get(i)?.author)
        }
    }

    override fun onError(msg: String) {
        //TODO 12
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}