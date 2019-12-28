package com.luuren.kanmovie.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bin.baselibrary.ext.log
import com.luuren.kanmovie.R
import com.luuren.kanmovie.common.BaseFragment
import com.luuren.kanmovie.viewmodles.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject


class MainFragment : BaseFragment() {

    private val mainViewModel by inject<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel.discoverMovieListLiveData.observe(this, Observer {
            it.toString().log()
        })

        mainViewModel.discoverTvListLiveData.observe(this, Observer {
            it.toString().log()
        })

        mainViewModel.getDiscoverMovieListForPageIndex(2)
        mainViewModel.getDiscoverTvListForPageIndex(2)

    }

}
