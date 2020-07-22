package com.articles.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.articles.R
import com.articles.databinding.NewReleaseItemBinding
import com.articles.remote.model.Article
import com.bumptech.glide.Glide

class NewReleasesAdapter : RecyclerView.Adapter<NewReleasesVH>() {

    private val newReleasesList: MutableList<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReleasesVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: NewReleaseItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.new_release_item, parent, false)
        return NewReleasesVH(binding)
    }

    override fun getItemCount() = newReleasesList.size

    override fun onBindViewHolder(holder: NewReleasesVH, position: Int) {
        holder.bind(newReleasesList[position])
    }

    fun populate(newReleases: List<Article>) {
        newReleasesList.clear()
        newReleasesList.addAll(newReleases)
        notifyDataSetChanged()
    }
}

class NewReleasesVH(private val binding: NewReleaseItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.articleSource.text = article.source.name
        binding.articleTitle.text = article.title
        binding.articleDescription.text = article.description

        Glide.with(binding.root)
            .load(article.urlToImage)
            .centerCrop()
            .into(binding.articleImage)
    }
}