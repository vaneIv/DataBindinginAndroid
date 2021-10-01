package com.vane.android.databindinginandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.vane.android.databindinginandroid.data.SimpleViewModel
import com.vane.android.databindinginandroid.databinding.ActivityPlainBinding

class PlainActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityPlainBinding = DataBindingUtil.setContentView(this, R.layout.activity_plain)

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this // use Fragment.viewLifecycleOwner for fragments
    }
}