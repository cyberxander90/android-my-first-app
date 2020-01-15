package com.example.myfirstapp

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author Inés Saint Martin
 */
class ApiClient {

    companion object {
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl("https://api.mercadolibre.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build()
            }

            return retrofit as Retrofit
        }
    }
}