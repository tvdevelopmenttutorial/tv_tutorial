package com.tutorial.tvapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : FragmentActivity() {

    lateinit var txtTitle: TextView
    lateinit var txtSubTitle: TextView
    lateinit var txtDescription: TextView

    lateinit var imgBanner: ImageView
    lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgBanner = findViewById(R.id.img_banner)
        txtTitle = findViewById(R.id.title)
        txtSubTitle = findViewById(R.id.subtitle)
        txtDescription = findViewById(R.id.description)


        listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()


        val gson = Gson()
        val i: InputStream = this.assets.open("movies.json")
        val br = BufferedReader(InputStreamReader(i))
        val dataList: DataModel = gson.fromJson(br, DataModel::class.java)

        listFragment.bindData(dataList)

        listFragment.setOnContentSelectedListener {
            updateBanner(it)
        }

    }

    fun updateBanner(dataList: DataModel.Result.Detail) {
        txtTitle.text = dataList.title
        txtDescription.text = dataList.overview


        val url = "https://www.themoviedb.org/t/p/w780" + dataList.backdrop_path
        Glide.with(this).load(url).into(imgBanner)
    }

}