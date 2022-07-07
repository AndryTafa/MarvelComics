package com.andry.marvelapplication.utils

import com.andry.marvelapplication.data.models.*

object EmptyObjects {
    fun emptyApiResponse(): ApiResponse {
        return ApiResponse(
            "",
            "",
            0,
            "",
            Data(
                0, 0, 0, listOf(
                    emptyComic()
                ), 0
            ),
            "",
            ""
        )
    }

    fun emptyComic(): Comic {
        return Comic(
            id = 0,
            title = "",
            description = "",
            format = "",
            pageCount = 0,
            thumbnail = emptyThumbnail(),
            series = emptySeries()
        )
    }

    fun emptyThumbnail(): Thumbnail {
        return Thumbnail(
            0,
            "",
            ""
        )
    }

    fun emptySeries(): Series {
        return Series(
            seriesId = 0,
            name = "",
            resourceURI = ""
        )
    }
}