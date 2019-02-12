package com.lz.wms.entity.api;

import java.util.List;

public class ResponseBreakageType extends BaseResponse {

    public List<ResultBean> Result;


    public static class ResultBean {
        /**
         * Name : string
         * Value : string
         * Description : string
         */

        public String Name;
        public String Value;
        public String Description;

    }
}
