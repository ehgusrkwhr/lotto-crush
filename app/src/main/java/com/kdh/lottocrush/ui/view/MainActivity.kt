package com.kdh.lottocrush.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.kdh.lottocrush.databinding.ActivityMainBinding
import com.kdh.lottocrush.ui.viewmodel.LottoViewModel
import com.kdh.lottocrush.util.LottoUtil
import com.kdh.lottocrush.util.LottoUtil.getNextEpisodeBasedonDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val lottoViewModel by viewModels<LottoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

      //  lottoViewModel.searchLottoInfo(1000)
        initView()
        observerView()

    }

    private fun initView(){
        //최신 회차 가져오기
        lottoViewModel.searchLastLottoInfo()
    }
    private fun observerView(){
        lottoViewModel.lottoNum.observe(this) {
            with(binding){
                lottoLastInfo.text = it.drwtNo1.toString()
                tvLastDate.text = it.drwNoDate
                tvLastResult.text = it.drwNo.toString()
            }
        }

    }

}