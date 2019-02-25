package com.lz.wms.entity.api;

import java.util.List;

public class ResponsePositionType extends BaseResponse {

    public List<ResultBean> Result;



    public static class ResultBean {
        /**
         * LocalNum : string
         * LocalName : string
         * LocalType : 0
         */

        public String LocalNum;
        public String LocalName;
        public int LocalType;

        @Override
        public String toString() {
            return LocalName;
        }
    }
}
