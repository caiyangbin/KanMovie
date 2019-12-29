package com.luuren.kanmovie.di

import com.luuren.kanmovie.Constants
import com.luuren.kanmovie.data.Api
import com.luuren.kanmovie.data.DiscoverMovieRepository
import com.luuren.kanmovie.viewmodles.HeatMovieViewModel
import com.luuren.kanmovie.viewmodles.MyInfoViewModel
import com.luuren.kanmovie.viewmodles.SearchMovieViewModel
import com.luuren.kanmovie.viewmodles.SplashViewModel
import com.luuren.libcommon.net.getOkHttpClient
import com.luuren.libcommon.net.getRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    //网络请求
    single { getOkHttpClient() }
    single { getRetrofit(Constants.Api.BASE_URL) }
    single { get<Retrofit>().create(Api::class.java) }

    //data
    single { DiscoverMovieRepository.getInstance(get()) }

    //viewModel
    viewModel { MyInfoViewModel(get()) }
    viewModel { HeatMovieViewModel() }
    viewModel { SearchMovieViewModel() }
    viewModel { SplashViewModel() }
}