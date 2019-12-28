package com.luuren.kanmovie

object Constants {

    class Api {
        companion object {
            const val BASE_URL = "https://api.themoviedb.org"

            /**全尺寸图片拼接前缀*/
            const val IMAGE_ORIGINAL_BASE_URL = "https://image.tmdb.org/t/p/original"

            /**小尺寸图片拼接前缀*/
            const val IMAGE_W500_BASE_URL = "https://image.tmdb.org/t/p/w500"

            const val API_KEY = "8ed327a26e13ce909acba31e719e7659"
            const val API_TOKEN_V4 =
                "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZWQzMjdhMjZlMTNjZTkwOWFjYmEzMWU3MTllNzY1OSIsInN1YiI6IjViZTM5MWVjOTI1MTQxNWM3NTAyMDllNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2u2qDL7R002xBoENo14NS_LB-3kG7uBxr-Z8G6Ql1GI"

        }
    }
}