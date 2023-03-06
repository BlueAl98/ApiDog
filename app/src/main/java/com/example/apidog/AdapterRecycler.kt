package com.example.apidog

import android.accounts.AccountManager.get
import android.content.Context
import android.nfc.tech.IsoDep.get
import android.nfc.tech.Ndef.get
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken.get
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class AdapterRecycler( private val dogList:List<String> ):
RecyclerView.Adapter<AdapterRecycler.ViewHolder>()
{
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


        fun bind(image:String){

            Picasso.get().load(image).into(itemView.imgDog)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecycler.ViewHolder {
       var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterRecycler.ViewHolder, position: Int) {

        val item: String = dogList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }


}