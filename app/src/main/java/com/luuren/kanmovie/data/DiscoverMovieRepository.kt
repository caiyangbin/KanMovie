package com.luuren.kanmovie.data

class DiscoverMovieRepository private constructor(private val api: Api) {

    companion object {
        @Volatile
        private var instance: DiscoverMovieRepository? = null

        fun getInstance(api: Api) =
            instance ?: synchronized(this) {
                instance ?: DiscoverMovieRepository(api).also { instance = it }
            }
    }


    suspend fun getDiscoverMovieList(pageIndex:Int): DiscoverMovieList {
        return api.getDiscoverMovieListForPage(pageIndex)
    }

    suspend fun getDiscoverTvList(pageIndex:Int): DiscoverTvList {
        return api.getDiscoverTvListForPage(pageIndex)
    }

}