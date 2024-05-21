package com.outerspace.web_flow.data_layer.web

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

const val BEARER = "bearer"
const val TOKEN = "TJALD094IK8M394JI5984JL4T89TE5JIO5"

val loggingInterceptor = HttpLoggingInterceptor(
    logger = {
            message -> Log.d("TEST", "Logger message: $message")
    })
    .apply { level = HttpLoggingInterceptor.Level.BASIC }

private fun getBearerString(): String = "bearer $TOKEN"

val customBearerInterceptor = Interceptor { chain ->
    val originalRequest: Request = chain.request()
    val addedRequest = originalRequest.newBuilder()
        .addHeader(BEARER, "bearer " + TOKEN)
        .build()
    chain.proceed(addedRequest)
}

class CustomBearerInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val addedRequest = originalRequest.newBuilder()
            .addHeader(BEARER, getBearerString())
            .build()
        return chain.proceed(addedRequest)
    }
}
