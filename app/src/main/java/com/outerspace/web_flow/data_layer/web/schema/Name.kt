package com.outerspace.web_flow.data_layer.web.schema

import com.squareup.moshi.Json

class Name {
    @Json(name = "title")
    var title: String? = null

    @Json(name = "first")
    var first: String? = null

    @Json(name = "last")
    var last: String? = null
}