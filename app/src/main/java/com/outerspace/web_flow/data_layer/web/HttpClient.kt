package com.outerspace.web_flow.data_layer.web

import com.outerspace.web_flow.data_layer.web.schema.UsersResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://randomuser.me"
private const val endpoint = "api"
private const val includeDefaultFields = "name,gender,nat,phone,cell,email"

private val okHttpClient = OkHttpClient.Builder()   // this is necessary if we need 0to add an interceptor
    .addInterceptor(loggingInterceptor)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClient)       // this is necessary to add an interceptor or tweak the OkHttp client
    .build()

private interface apiService {
    @GET("$endpoint")
    suspend fun fetchUsers(@Path("results") resultCount: Int, @Path("inc") includeFields: String = includeDefaultFields): UsersResponse
}

private object API {
    val retrofitService: apiService by lazy {
        retrofit.create(apiService::class.java)
    }
}

class HttpClient {
    suspend fun fetchUsers(resultCount: Int): UsersResponse {
        return API.retrofitService.fetchUsers(resultCount)
    }
}