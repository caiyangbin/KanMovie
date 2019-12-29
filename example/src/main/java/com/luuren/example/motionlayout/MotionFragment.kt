package com.luuren.example.motionlayout

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.bin.baselibrary.ext.log

import com.luuren.example.R
import kotlinx.android.synthetic.main.motion_fragment.*
import org.koin.android.ext.android.inject

class MotionFragment : Fragment() {

    companion object {
        fun newInstance() = MotionFragment()
    }

//    private  val viewModel by inject<MotionViewModel>()
    private val ss :MotionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.motion_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            "back".log()
        }
    }
}
