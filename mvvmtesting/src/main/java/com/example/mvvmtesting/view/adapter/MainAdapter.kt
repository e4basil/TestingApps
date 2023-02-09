package com.example.mvvmtesting.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmtesting.R
import com.example.mvvmtesting.databinding.AdapterBinding
import com.example.mvvmtesting.model.Article

class MainAdapter : ListAdapter<Article, MainAdapter.RepositoriesViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AdapterBinding.inflate(layoutInflater, parent, false)
        return RepositoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        val article = getItem(position) ?: return
        holder.onBind(article)
    }

    class RepositoriesViewHolder(private val binding: AdapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(articleItem:Article){
            binding.run {
                source.text=articleItem.source?.name
                title.text= articleItem.title
                Glide.with(binding.root.context)
                    .load(articleItem.imgUrl)
                    .apply(
                        RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_logo))
                    .into(binding.articleImage)

                setOnClickListener(articleItem)
            }

        }

        private fun setOnClickListener(articleItem: Article) {}
    }


    companion object {
        val DiffUtil: DiffUtil.ItemCallback<Article> = object :
            DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return newItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return newItem == oldItem
            }

        }
    }


}
