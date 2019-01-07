package com.lz.wms.net;

import com.lz.wms.entity.RequestLogin;
import com.lz.wms.entity.ResponseLogin;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    String login = "http://lzsbzsb.nat123.net:3303/api/login";

    @POST(login)
    Observable<ResponseLogin> login(@Body RequestLogin requestLogin);
}
