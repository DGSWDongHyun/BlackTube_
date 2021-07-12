package kr.hs.dgsw.donghyeon.blacktube.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.donghyeon.blacktube.R
import kr.hs.dgsw.donghyeon.blacktube.base.BaseFragment
import kr.hs.dgsw.donghyeon.blacktube.databinding.FragmentProfileBinding
import kr.hs.dgsw.donghyeon.blacktube.viewmodel.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_profile
    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

    override fun onViewCreated(view: FragmentProfileBinding) {

    }
}