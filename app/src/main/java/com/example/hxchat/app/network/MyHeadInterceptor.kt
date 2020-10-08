package com.example.hxchat.app.network

import com.example.hxchat.app.util.CacheUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOError
import java.io.IOException

/**
 *Created by Pbihao
 * on 2020/10/7
 */

class MyHeadInterceptor  : Interceptor{

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("token", "pbh123").build()
        builder.addHeader("device", "Android").build()
        builder.addHeader("isLogin", CacheUtil.isLogin().toString()).build()
        return chain.proceed(builder.build())
    }
}