package com.kdh.lottocrush.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kdh.lottocrush.databinding.ActivityMainBinding
import com.kdh.lottocrush.ui.viewmodel.LottoViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val lottoViewModel by viewModels<LottoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lottoViewModel.searchLottoInfo(1000)

    }

}