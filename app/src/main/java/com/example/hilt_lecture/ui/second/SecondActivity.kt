package com.example.hilt_lecture.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilt_lecture.databinding.ActivitySecondBinding
import com.example.hilt_lecture.data.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    @Inject
    lateinit var repository:MyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}