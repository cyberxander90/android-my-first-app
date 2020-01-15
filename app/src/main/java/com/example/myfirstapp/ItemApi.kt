package com.example.myfirstapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Inés Saint Martin
 */
interface ItemApi {

    @GET("")
    fun getItemsList(): Call<List<Item>>

    @GET("items/{itemId}")
    fun getItem(@Path("itemId") itemId: String): Call<Item>

}