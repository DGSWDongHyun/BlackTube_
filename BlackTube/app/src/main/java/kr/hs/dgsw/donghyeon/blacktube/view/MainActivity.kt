package kr.hs.dgsw.donghyeon.blacktube.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
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
        AppBarConfiguration.Builder(R.id.icon_home, R.id.icon_playlist, R.id.icon_user).build()
        val navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(view.bottomNavigationView, navController)
    }
}