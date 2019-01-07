package com.lz.wms.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitProvider {
    public static final String BASE_URL="http://127.0.0.1/";
    private static Api api=null;


    public static Api getApi(){
        if(api!=null){
            return api;
        }
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.client(getOkHttpClient());
        Retrofit retrofit=builder.build();
        api=retrofit.create(Api.class);
        return api;
    }



    private static OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);
        return builder.build();
    }

}
