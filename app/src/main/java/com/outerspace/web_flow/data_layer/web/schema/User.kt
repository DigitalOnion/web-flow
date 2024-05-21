package com.outerspace.web_flow.data_layer.web.schema

import com.squareup.moshi.Json

class User {
    @Json(name = "gender")
    var gender: String? = null

    @Json(name = "name")
    var name: Name? = null

    @Json(name = "email")
    var email: String? = null

    @Json(name = "phone")
    var phone: String? = null

    @Json(name = "cell")
    var cell: String? = null
}