package com.luuren.kanmovie.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.luuren.kanmovie.R
import com.luuren.kanmovie.common.BaseFragment
import com.luuren.kanmovie.viewmodles.SplashViewModel
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.*


class SplashFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            delay(2000)
            withContext(Dispatchers.Main){
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
            }
        }
    }

    override fun isFinish(): Boolean = false

}
