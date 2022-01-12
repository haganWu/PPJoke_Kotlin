package com.hagan.libnetwork

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

class ApiService {

    companion object {

        var okHttpClient: OkHttpClient? = null
        var mBaseUrl: String? = null
        var mConvert: Convert<*>? = null

        fun <T> init(baseUrl: String, convert: Convert<T>) {
            this.mBaseUrl = baseUrl
            this.mConvert = convert ?: JsonConvert<T>()
        }

        fun <T> get(url: String): GetRequest<T> {
            return GetRequest(mBaseUrl + url)
        }

        fun <T> post(url: String): PostRequest<T> {
            return PostRequest(mBaseUrl + url)
        }


        init {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
            //HTTPS 请求证书信任问题
            val trustManager = arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                }

                override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }

            })

            val ssl = SSLContext.getInstance("SSL")
            ssl.init(null, trustManager, SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(ssl.socketFactory)
            //信任所有的域名
            HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }

        }

    }
}