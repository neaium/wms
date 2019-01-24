package com.lz.wms.entity.api;

import com.google.gson.annotations.SerializedName;

public class RequestLogin {
    public RequestLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * 用户名
     */
    @SerializedName("UserName")
    private String userName;
    /**
     * 密码
     */
    @SerializedName("Password")
    private String password;

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
