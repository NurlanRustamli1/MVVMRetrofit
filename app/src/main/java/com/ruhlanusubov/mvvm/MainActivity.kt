package com.ruhlanusubov.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruhlanusubov.mvvm.adapter.ProductAdapter
import com.ruhlanusubov.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val productAdapter=ProductAdapter()
    private lateinit var viewModel:MainMVVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        getData()
    }

    private fun getData(){
        adapter()
        viewModel= ViewModelProvider(this)[MainMVVM::class.java]
        viewModel.getProduct(this)
        viewModel.productList.observe(this, Observer {
            productAdapter.updateList(it)
        })
    }

    private fun adapter(){
        binding.productRv.apply {
            adapter=productAdapter
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        }
    }
}