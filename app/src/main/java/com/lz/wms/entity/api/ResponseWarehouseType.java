package com.lz.wms.entity.api;

import java.util.List;

public class ResponseWarehouseType extends BaseResponse {

    public List<ResultBean> Result;



    public static class ResultBean {
        /**
         * SnNum : string
         * WarehouseName : string
         */

       public String SnNum;
       public String WarehouseName;


    }
}
