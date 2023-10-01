package com.example.tmdbclient.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvShowBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var tvShowBinding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)
        tvShowBinding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        tvShowViewModel = ViewModelProvider(this,factory)[TvShowViewModel::class.java]
        initRecyclerView()
    }
    private fun initRecyclerView(){
        tvShowBinding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        tvShowBinding.tvShowRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        tvShowBinding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getShows()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
            } else {
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun updateMovies(){
        tvShowBinding.tvShowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateShows()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
            } else {
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
            }
        }
    }
}