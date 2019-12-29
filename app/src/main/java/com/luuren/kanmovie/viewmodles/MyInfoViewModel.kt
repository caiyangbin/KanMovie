package com.luuren.kanmovie.viewmodles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luuren.kanmovie.data.DiscoverMovieList
import com.luuren.kanmovie.data.DiscoverMovieRepository
import com.luuren.kanmovie.data.DiscoverTvList
import kotlinx.coroutines.launch

class MyInfoViewModel(private val rep: DiscoverMovieRepository) : ViewModel() {

    val discoverMovieListLiveData: MutableLiveData<DiscoverMovieList> by lazy {
        MutableLiveData<DiscoverMovieList>()
    }

    val discoverTvListLiveData: MutableLiveData<DiscoverTvList> by lazy {
        MutableLiveData<DiscoverTvList>()
    }

    fun getDiscoverMovieListForPageIndex(pageIndex: Int) {
        viewModelScope.launch {
            val discoverMovieList = rep.getDiscoverMovieList(pageIndex)
            discoverMovieListLiveData.postValue(discoverMovieList)
        }
    }

    fun getDiscoverTvListForPageIndex(pageIndex: Int) {
        viewModelScope.launch {
            val discoverTvList = rep.getDiscoverTvList(pageIndex)
            discoverTvListLiveData.postValue(discoverTvList)
        }
    }
}
