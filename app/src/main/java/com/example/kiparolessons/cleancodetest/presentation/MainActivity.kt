package com.example.kiparolessons.cleancodetest.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kiparolessons.cleancodetest.app.App
import com.example.kiparolessons.cleancodetest.presentation.viewmodel.MainViewModel
import com.example.kiparolessons.cleancodetest.presentation.viewmodel.MainViewModelFactory
import com.example.kiparolessons.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, vmFactory)
            .get(MainViewModel::class.java)

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