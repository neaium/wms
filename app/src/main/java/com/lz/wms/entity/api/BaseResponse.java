package com.lz.wms.entity.api;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("Code")
    public int code;
    @SerializedName("Message")
    public String message;
    @SerializedName("SubCode")
    public int subCode;
    @SerializedName("SubMessage")
    public String subMessage;

}
