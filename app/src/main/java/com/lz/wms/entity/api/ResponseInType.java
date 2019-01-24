package com.lz.wms.entity.api;

import java.util.List;

public class ResponseInType extends BaseResponse {
    public List<ResultBean> Result;


    public static class ResultBean {


        public String Name;
        public String Value;
        public String Description;
    }

}
