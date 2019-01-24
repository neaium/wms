package com.lz.wms.net;

import com.lz.wms.entity.api.RequestLogin;
import com.lz.wms.entity.api.ResponseInType;
import com.lz.wms.entity.api.ResponseLogin;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String LOGIN = "api/Base/Login";
    String GET_IN_TYPE_LIST="api/Base/GetInTypeList";

    @POST(LOGIN)
    Observable<ResponseLogin> login(@Body RequestLogin requestLogin);
    @GET(GET_IN_TYPE_LIST)
    Observable<ResponseInType> getInTypeList();
}
