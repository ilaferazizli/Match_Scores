 package com.apple.matchscores

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.apple.matchscores.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = Api.retrofitService.fetchData()
                withContext(Dispatchers.Main) {
                    binding.loading.visibility = GONE
                    binding.gamenamerecycler.layoutManager = layoutManager
                    binding.gamenamerecycler.adapter = GameNameAdapter(response.data)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    binding.loading.visibility = GONE
                    binding.errorMessage.text = e.message
                    binding.errorMessage.visibility = VISIBLE
                }
            }
        }
    }
}