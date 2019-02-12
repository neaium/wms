package com.lz.wms.ui.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lz.wms.entity.LoginType;
import com.lz.wms.entity.api.ResponseWarehouseType;

import java.util.ArrayList;
import java.util.List;

public class LoginTypeAdapter extends BaseAdapter {

    private List<ResponseWarehouseType.ResultBean> datas;

    public LoginTypeAdapter(List<ResponseWarehouseType.ResultBean> datas){
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public ResponseWarehouseType.ResultBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        }
        TextView tv= (TextView) convertView;
        tv.setText(getItem(position).WarehouseName);
        return convertView;
    }


}
