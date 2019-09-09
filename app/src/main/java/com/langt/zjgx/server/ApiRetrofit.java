package com.langt.zjgx.server;

import com.langt.zjgx.base.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {
    private static ApiRetrofit apiRetrofit;
    private static ApiServer apiServer;
    protected static final Object monitor = new Object();
    private static Retrofit retrofit;
    private static OkHttpClient.Builder mOkHttpClient;

    private ApiRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    public static ApiRetrofit getInstance() {
        if (apiRetrofit == null) {
            synchronized (monitor) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }
        return apiRetrofit;
    }


    private  OkHttpClient getOkHttpClient(){
        if(mOkHttpClient == null){
            mOkHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(30, TimeUnit.SECONDS)//链接超时
                    .readTimeout(30,TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)//重连
//                    .addInterceptor(new HttpLoggingInterceptor())
//                    .addNetworkInterceptor(interceptor)//添加header
                    .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));//网络请求日志
        }
        return mOkHttpClient.build();
    }


    public  ApiServer getApiServer() {
        synchronized (monitor) {
            if (apiServer == null) {
                apiServer = retrofit.create(ApiServer.class);
            }
            return apiServer;
        }
    }
}
