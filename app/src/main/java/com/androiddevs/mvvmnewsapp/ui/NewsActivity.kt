package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
    }

    private val navController: NavController by lazy { navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository=NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory=NewsViewModelProviderFactory(application,newsRepository)
        viewModel= ViewModelProvider(owner = this,viewModelProviderFactory)[NewsViewModel::class.java]
        bottomNavigationView.setupWithNavController(navController)
    }


}

//    lateinit var viewModel: NewsViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_news)
//
//        val newsRepository=NewsRepository(ArticleDatabase(this))
//        val viewModelProviderFactory=NewsViewModelProviderFactory(application,newsRepository)
//        viewModel=ViewModelProvider(owner = this,viewModelProviderFactory).get(NewsViewModel::class.java)
//        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
//    }
//}
