package com.tutorial.tvapp

data class DataModel(
    val result: List<Result> = listOf()
) {
    data class Result(
        val details: List<Detail> = listOf(),
        val id: Int = 0,
        val title: String = ""
    ) {
        data class Detail(
            val adult: Boolean = false,
            val backdrop_path: String = "",
            val first_air_date: String = "",
            val genre_ids: List<Int> = listOf(),
            val id: Int = 0,
            val name: String = "",
            val origin_country: List<String> = listOf(),
            val original_language: String = "",
            val original_name: String = "",
            val original_title: String = "",
            val overview: String = "",
            val popularity: Double = 0.0,
            val poster_path: String = "",
            val release_date: String = "",
            val title: String = "",
            val video: Boolean = false,
            val vote_average: Double = 0.0,
            val vote_count: Int = 0
        )
    }
}