package com.playgendary.sportmasterss

import retrofit2.Response
import retrofit2.http.GET

interface SomeInterface {

    @GET("json/?key=ZSSz86ONagSoYRv")
    suspend fun getData(): Response<CountryCodeJS>

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}

data class CountryCodeJS(
    val city: String,
    val country: String,
    val countryCode: String,
)
data class GeoDev(
    val geo: String,
    val view: String,
    val appsChecker: String,
)