package com.ruhlanusubov.mvvm.service

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

 fun downloadImage(url:String,context:Context,imageView: ImageView){
    Glide.with(context).load(url).into(imageView)
}
fun showToast(context: Context,message:String){
    Toast.makeText(context,message,Toast.LENGTH_SHORT)
}