package kr.hs.dgsw.donghyeon.blacktube.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.donghyeon.blacktube.R
import kr.hs.dgsw.donghyeon.blacktube.base.BaseFragment
import kr.hs.dgsw.donghyeon.blacktube.databinding.FragmentPlayListBinding
import kr.hs.dgsw.donghyeon.blacktube.viewmodel.PlayListViewModel

class PlayListFragment : BaseFragment<FragmentPlayListBinding, PlayListViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_play_list
    override val viewModel: PlayListViewModel
        get() = ViewModelProvider(requireActivity())[PlayListViewModel::class.java]

    override fun onViewCreated(view: FragmentPlayListBinding) {
    }

}