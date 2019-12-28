package com.luuren.kanmovie.data

import com.luuren.kanmovie.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/3/discover/movie")
    suspend fun getDiscoverMovieListForPage(
        @Query("page") pageIndex: Int = 1,
        @Query("language") language: String = "zh-CN",
        @Query("api_key") apiKey: String = Constants.Api.API_KEY
    ): DiscoverMovieList

    @GET("/3/discover/tv")
    suspend fun getDiscoverTvListForPage(
        @Query("page") pageIndex: Int = 1,
        @Query("language") language: String = "zh-CN",
        @Query("api_key") apiKey: String = Constants.Api.API_KEY
    ): DiscoverTvList

}