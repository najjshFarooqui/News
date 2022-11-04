package com.najishfarooqui.news

import android.widget.TextView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NewsAdapter(
    private val mList: List<Article>
) : RecyclerView.Adapter<NewsAdapter.CustomViewHolder>() {


    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newsTitle = view.findViewById<TextView>(R.id.tvNewsTitle)
        var newsImage = view.findViewById<ImageView>(R.id.ivNews)
        var parent = view.findViewById<ConstraintLayout>(R.id.parent)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_items, parent, false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.newsTitle.text = mList[position].title
        Glide.with(holder.newsTitle.context).load(mList[position].urlToImage).into(holder.newsImage)
        holder.parent.setOnClickListener {
            if (mOnListener != null) {
                mOnListener!!.onClick(mList[position])
            }
        }


    }

    override fun getItemCount(): Int {
        return mList.size
    }

    var mOnListener: OnClickListener? = null

    interface OnClickListener {
        fun onClick(obj: Article)
    }

    fun setOnClickListener(mSlotClickListener: OnClickListener) {
        this.mOnListener = mSlotClickListener
    }

}