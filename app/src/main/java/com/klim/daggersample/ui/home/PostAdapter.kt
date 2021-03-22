package com.klim.koinsample.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klim.daggersample.databinding.ItemPostBinding
import com.klim.daggersample.ui.home.viewEntity.PostView

class PostAdapter : RecyclerView.Adapter<PostViewHolder>() {

    val data: ArrayList<PostView> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = data[position]
        holder.binding.tvTitle.text = post.title
        holder.binding.tvDescription.text = post.body
    }

    override fun getItemCount() = data.size
}