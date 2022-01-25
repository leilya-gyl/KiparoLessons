package com.example.kiparolessons.cleancodetest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kiparolessons.cleancodetest.presentation.viewmodel.MainViewModel
import com.example.kiparolessons.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        Log.e("AAA", "Activity created")

        //vm = ViewModelProvider(this, MainViewModelFactory(this))
        //    .get(MainViewModel::class.java)

        vm.resultLive.observe(this, { text ->
            mainBinding.dataTextView.text = text
        })

        mainBinding.run {
            receiveButton.setOnClickListener {
                vm.load()
            }

            saveButton.setOnClickListener {
                val text = dataEditText.text.toString()
                vm.save(text)
            }
        }
    }
}