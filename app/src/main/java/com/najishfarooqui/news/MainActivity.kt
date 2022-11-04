package com.najishfarooqui.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel
    private lateinit var rvNews: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = (application as NewsApplication).newsRepository

        viewModel =
            ViewModelProvider(this, NewsViewModelFactory(repository)).get(NewsViewModel::class.java)
        rvNews = findViewById(R.id.rvNews)

        viewModel.getAllNews()
        viewModel.newsLiveData.observe(this, Observer {
            rvNews.layoutManager = LinearLayoutManager(this)
            adapter = NewsAdapter(it.articles)
            rvNews.adapter = adapter

            adapter.setOnClickListener(object : NewsAdapter.OnClickListener {
                override fun onClick(obj: Article) {
                    val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                    intent.putExtra("NEWS_OBJ", obj)
                    startActivity(intent)


                }

            })
        })

    }
}