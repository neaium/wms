package com.lz.wms.entity.api;

import com.lz.wms.entity.InboundItem;

import java.util.List;

public class RequestAdd {

    /**
     * SupNum : string
     * SupName : string
     * AgencyFree : 0
     * Remark : string
     * UserNum : string
     * Items : [{"ProductNum":"string","BarCode":"string","ProductName":"string","Size":"string","BatchNum":"string","LastTime":"string","Num":0,"NetWeight":0,"GrossWeight":0,"Volume":0,"PalletNum":0,"Remark":"string","LocalNum":"string"}]
     */

    public String SupNum;
    public String SupName;
    public int AgencyFree;
    public String Remark;
    public String UserNum;
    public List<InboundItem> Items;
    public RequestAdd(String supNum, String supName, int agencyFree, String remark, String userNum, List<InboundItem> items) {
        SupNum = supNum;
        SupName = supName;
        AgencyFree = agencyFree;
        Remark = remark;
        UserNum = userNum;
        Items = items;
    }

}
