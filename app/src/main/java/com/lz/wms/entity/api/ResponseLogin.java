package com.lz.wms.entity.api;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin extends BaseResponse {
    @SerializedName("Result")
    public ResultBean result;

    public static class ResultBean {
        @SerializedName("UserNum")
        public String userNum;
        @SerializedName("UserCode")
        public String userCode;
        @SerializedName("UserName")
        public String userName;
        @SerializedName("RoleNum")
        public String roleNum;
        @SerializedName("RoleName")
        public String roleName;
        @SerializedName("UserType")
        public int userType;
        @SerializedName("StorageNum")
        public String storageNum;
        @SerializedName("StorageName")
        public String storageName;
        @SerializedName("SupNum")
        public String supNum;
        @SerializedName("SupName")
        public String supName;

    }
}
