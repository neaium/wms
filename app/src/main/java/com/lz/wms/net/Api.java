package com.lz.wms.net;

import com.lz.wms.entity.api.RequestAdd;
import com.lz.wms.entity.api.RequestLogin;
import com.lz.wms.entity.api.ResponseAdd;
import com.lz.wms.entity.api.ResponseBreakageType;
import com.lz.wms.entity.api.ResponseOutType;
import com.lz.wms.entity.api.ResponseInType;
import com.lz.wms.entity.api.ResponseLogin;
import com.lz.wms.entity.api.ResponsePositionType;
import com.lz.wms.entity.api.ResponseWarehouseType;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String LOGIN = "api/Base/Login";
    String GET_WAREHOUSE_LIST = "api/Base/GetWareList";
    String GET_IN_TYPE_LIST = "api/Base/GetInTypeList";
    String GET_OUT_TYPE_LIST = "api/Base/GetOutTypeList";
    String GET_BREAKAGE_TYPE_LIST = "api/Base/GetBadTypeList";
    String GET_POSITION_LIST = "api/Base/GetPositionList";
    String ADD="api/InStore/Add";

    @POST(LOGIN)
    Observable<ResponseLogin> login(@Body RequestLogin requestLogin);

    @POST(GET_WAREHOUSE_LIST)
    Observable<ResponseWarehouseType> getWarehouseType();

    @POST(ADD)
    Observable<ResponseAdd> add(@Body RequestAdd requestAdd);

    @GET(GET_IN_TYPE_LIST)
    Observable<ResponseInType> getInTypeList();

    @GET(GET_OUT_TYPE_LIST)
    Observable<ResponseOutType> getOutTypeList();

    @GET(GET_BREAKAGE_TYPE_LIST)
    Observable<ResponseBreakageType> getBreakageTypeList();

    @GET(GET_POSITION_LIST)
    Observable<ResponsePositionType> getPositionList();

}
