package com.example.apidog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: AdapterRecycler
    lateinit var linearLayoutmanager: LinearLayoutManager
    private val dogimages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        linearLayoutmanager = LinearLayoutManager(this)
        recyclerdata.layoutManager = linearLayoutmanager
        recyclerdata.setHasFixedSize(true)




        val quotesApi = RetrofitHelper.getInstance().create(ApiDogs::class.java)


        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            val dogs = result.body()

            runOnUiThread{
                if(result.isSuccessful){
                    val images = dogs?.message ?: emptyList()
                    dogimages.clear()
                    dogimages.addAll(images)
                    Log.d("Links ", dogimages.toString())

                    myAdapter = AdapterRecycler(dogimages)
                    recyclerdata.adapter = myAdapter
                    myAdapter.notifyDataSetChanged()

                }
            }


        }



    }



}