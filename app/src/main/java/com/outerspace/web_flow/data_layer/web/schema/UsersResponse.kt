package com.outerspace.web_flow.data_layer.web.schema

import com.squareup.moshi.Json

class UsersResponse {
    @Json(name = "results")
    var users: List<User>? = null

    @Json(name = "info")
    var info: Info? = null
}