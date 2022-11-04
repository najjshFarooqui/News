package com.najishfarooqui.news

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class NewsDetailActivity : AppCompatActivity() {
    private lateinit var title : TextView
    private lateinit var description: TextView
    private lateinit var image: ImageView
    private lateinit var authorName: TextView
    private lateinit var date: TextView
    private lateinit var save: Button
    private lateinit var share: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        title = findViewById(R.id.tvTitle)
        description = findViewById(R.id.tvDescription)
        image = findViewById(R.id.ivImage)
        authorName = findViewById(R.id.tvAuthorName)
        share = findViewById(R.id.ivShare)
        date = findViewById(R.id.tvDate)
        save = findViewById(R.id.btnSaveImage)


        val newsArticle = intent.getSerializableExtra("NEWS_OBJ") as Article?
        Glide.with(this).load(newsArticle?.urlToImage).into(image)
        title.text = newsArticle?.title
        description.text = newsArticle?.description
        authorName.text = newsArticle?.author


        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val dateX: Date = dateFormat.parse(newsArticle?.publishedAt)
        val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dateStr: String = formatter.format(dateX)
        date.text = dateStr

        share.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = newsArticle?.description
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, newsArticle?.title)
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        save.setOnClickListener {
            Toast.makeText(this,"Image saved successfully",Toast.LENGTH_SHORT).show()
        }



    }
}