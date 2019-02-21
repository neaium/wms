package com.lz.wms.entity;

import java.io.Serializable;

public class InboundItem implements Serializable {

    /**
     * ProductNum : string
     * BarCode : string
     * ProductName : string
     * Size : string
     * BatchNum : string
     * LastTime : string
     * Num : 0
     * NetWeight : 0
     * GrossWeight : 0
     * Volume : 0
     * PalletNum : 0
     * Remark : string
     * LocalNum : string
     */

    public String ProductNum;
    public String ProductName;
    public String Size;
    public String BatchNum;
    public String LastTime;
    public int Num;
    public String LocalNum;
}


