package kr.hs.dgsw.donghyeon.blacktube.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.donghyeon.blacktube.R
import kr.hs.dgsw.donghyeon.blacktube.base.BaseFragment
import kr.hs.dgsw.donghyeon.blacktube.databinding.FragmentHomeBinding
import kr.hs.dgsw.donghyeon.blacktube.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

    override fun onViewCreated(view: FragmentHomeBinding) {
        with(viewModel) {
            isEnded.observe(requireActivity(), Observer { isEnded ->
                if(isEnded) {
                    onMoreVideoList()
                    this.isEnded.value = false
                }
            })
        }
    }
}