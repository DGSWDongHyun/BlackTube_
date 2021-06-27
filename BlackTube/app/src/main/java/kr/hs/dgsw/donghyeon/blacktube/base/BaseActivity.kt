package kr.hs.dgsw.donghyeon.blacktube.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.donghyeon.blacktube.BR

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : AppCompatActivity(){

    lateinit var viewDataBinding : VB

    abstract val layoutRes : Int
    abstract val viewModel : VM

    abstract fun onViewCreated(view : VB)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performBinding()
        onViewCreated(viewDataBinding)
    }

    private fun performBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutRes)

        viewDataBinding.run {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }
    }
}