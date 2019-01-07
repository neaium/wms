package com.lz.wms.entity;

public class DialogMessage {
    public String message;
    public Object tag;
    public DialogMessage(String message) {
        this.message = message;
    }

    public DialogMessage(String message, Object tag) {
        this.message = message;
        this.tag = tag;
    }
}
