package com.ruhlanusubov.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruhlanusubov.mvvm.databinding.ItemProductBinding
import com.ruhlanusubov.mvvm.model.Product
import com.ruhlanusubov.mvvm.service.downloadImage

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private val productList=ArrayList<Product>()
    inner class ProductHolder(val binding: ItemProductBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val layout=ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductHolder(layout)
    }

    override fun getItemCount(): Int=productList.size

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val item=productList[position]
        holder.binding.apply {
            downloadImage(item.thumbnail.toString(),holder.itemView.context,productImage)
        }
    }
    fun updateList(list: List<Product>){
        productList.clear()
        productList.addAll(list)
        notifyDataSetChanged()
    }
}