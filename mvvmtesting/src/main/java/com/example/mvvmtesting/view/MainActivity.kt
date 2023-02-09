package com.example.mvvmtesting.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvmtesting.databinding.ActivityMainBinding
import com.example.mvvmtesting.utils.ResponseData
import com.example.mvvmtesting.view.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainActivityViewModel by viewModels()
    lateinit var binding :ActivityMainBinding
    lateinit var adapter:MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initObservers()
        mainViewModel.fetchArticles()
    }

    private fun initAdapter() {
        adapter = MainAdapter().apply {
            binding.rv.adapter = this
            binding.rv.layoutManager=StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        }

    }

    private fun initObservers() {
        mainViewModel.dataListLiveData.observe(this) {

            when (it) {
                is ResponseData.Loading -> {
                    binding.pb.visibility=View.VISIBLE
                }

                is ResponseData.Error -> {
                    binding.pb.visibility=View.GONE
                }
                is ResponseData.Success->{
                    binding.pb.visibility=View.GONE
                    adapter.submitList(it.data)
                }

                else -> {}
            }
        }
    }
}