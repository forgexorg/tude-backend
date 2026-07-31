package net.joohnserde.forgex.model


class WebResponse<T>(

    val code: Int,

    val status: String,

    val data: T

)
