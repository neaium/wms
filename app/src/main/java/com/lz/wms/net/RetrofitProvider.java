package com.lz.wms.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lz.wms.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitProvider {
    public static final String BASE_URL = "http://deopenapi.gitwms.com/";
    private static Api api = null;

    public static Api getApi() {
        if (api != null) {
            return api;
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient());
        Retrofit retrofit = builder.build();
        api = retrofit.create(Api.class);
        return api;


    }

    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor);
        return builder.build();
    }
}
