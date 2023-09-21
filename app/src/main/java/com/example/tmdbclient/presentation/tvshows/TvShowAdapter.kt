package com.example.tmdbclient.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.tvShows.TvShow
import com.example.tmdbclient.databinding.ListItemBinding


class TvShowAdapter :RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(shows:List<TvShow>){
         tvShowList.clear()
         tvShowList.addAll(shows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(tvShowList[position])
    }
}



class MyViewHolder(private val binding: ListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(tvShow:TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

   }

}