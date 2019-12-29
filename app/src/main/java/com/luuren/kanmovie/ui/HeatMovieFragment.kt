package com.luuren.kanmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bin.baselibrary.ext.log
import com.luuren.kanmovie.R
import com.luuren.kanmovie.common.BaseFragment
import com.luuren.kanmovie.viewmodles.MyInfoViewModel
import org.koin.android.ext.android.inject


class HeatMovieFragment : BaseFragment() {

    private val mainViewModel by inject<MyInfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_heat_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        "HeatMovieFragment".log()
    }

    override fun isFinish(): Boolean = true

}
