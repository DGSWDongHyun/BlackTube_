package kr.hs.dgsw.donghyeon.blacktube.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.donghyeon.blacktube.R
import kr.hs.dgsw.donghyeon.blacktube.base.BaseActivity
import kr.hs.dgsw.donghyeon.blacktube.databinding.ActivityMainBinding
import kr.hs.dgsw.donghyeon.blacktube.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this)[MainViewModel::class.java]

    override fun onViewCreated(view: ActivityMainBinding) {
        
    }
}