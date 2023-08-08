package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.buttonCounter.setOnClickListener {
            binding.textCounter.text = counter++.toString()
        }

        binding.buttonDownloading.setOnClickListener {
            // usando corrotinas, para usarmos corrotinas definimos o seu escopo
            // e depois lançamos o codigo que queremos executar
            CoroutineScope(Dispatchers.IO).launch {
                downlodingCounter()
            }
        }
    }

    private fun downlodingCounter() {
        for(i in 1..10000) {
            Log.i("TAG", "Downloading $i in ${Thread.currentThread().name}")
        }
    }
}