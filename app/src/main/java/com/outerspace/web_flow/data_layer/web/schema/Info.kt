package com.outerspace.web_flow.data_layer.web.schema

import com.squareup.moshi.Json

class Info {
    @Json(name = "seed")
    var seed: String? = null

    @Json(name = "results")
    var results: Int? = null

    @Json(name = "page")
    var page: Int? = null

    @Json(name = "version")
    var version: String? = null
}