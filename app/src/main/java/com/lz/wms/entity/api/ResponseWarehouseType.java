package com.lz.wms.entity.api;

import android.support.annotation.NonNull;

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

        @NonNull
        @Override
        public String toString() {
            return WarehouseName;
        }
    }
}
