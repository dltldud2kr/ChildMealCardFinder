package com.example.childmealcardfinder

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.childmealcardfinder.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: ShopListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        Log.d("MainActivity", "onCreate")


// Observe the lists LiveData
        viewModel.shopList.observe(this, Observer { shopList ->
            // Handle the updated shop list here (e.g., update the UI)
            shopList?.let {
                for (shop in it) {
                    Log.d("MainActivity", "Shop: ${shop.shopName}")
                }
            }
        })

        // Call getShopLists to fetch the data
        viewModel.getShopLists()

        Log.d("MainActivity", "onCreate")
    }

    }


