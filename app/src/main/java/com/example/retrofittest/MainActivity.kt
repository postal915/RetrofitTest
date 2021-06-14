package com.example.retrofittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittest.databinding.ActivityMainBinding
import com.example.retrofittest.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        button.setOnClickListener {
            val myNumber = number_editText.text.toString()
            viewModel.getPost(myNumber.toInt())
            viewModel.myResponse2.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    textView.text = response.body().toString()
                } else {
                    Log.d("Response error", response.errorBody().toString())
                    textView.text = response.code().toString()
                }
            })
        }
    }
}