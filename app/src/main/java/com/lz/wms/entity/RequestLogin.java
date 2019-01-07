package com.lz.wms.entity;

public class RequestLogin {
    public String userName;
    public String password;
    int type;

    public RequestLogin(String userName, String password, int type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
}
