package ru.androidschool.intensiv.data

data class TvShow(
    val title: String? = "",
    val voteAverage: Double = 0.0,
    val posterUrl: String = "https://avatars.mds.yandex.net/get-kino-vod-films-gallery/1668876/932513297931d9bf53e1f8863fc16f95/600x380"
) {
    val rating: Float
        get() = voteAverage.div(2).toFloat()
}
