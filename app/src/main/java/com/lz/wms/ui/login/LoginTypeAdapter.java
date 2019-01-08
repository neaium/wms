package com.lz.wms.ui.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lz.wms.entity.LoginType;

import java.util.ArrayList;
import java.util.List;

public class LoginTypeAdapter extends BaseAdapter {

    public static final LoginTypeAdapter getDefault(){
        List<LoginType> datas=new ArrayList<>();
        datas.add(new LoginType("请选择仓库",-1));
        datas.add(new LoginType("北京仓库",0));
        datas.add(new LoginType("上海仓库",1));
        datas.add(new LoginType("广州仓库",4));
        datas.add(new LoginType("深圳仓库",5));
        return new LoginTypeAdapter(datas);
    }


    private List<LoginType> datas;

    public LoginTypeAdapter(List<LoginType> datas){
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public LoginType getItem(int position) {
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
        tv.setText(getItem(position).name);
        return convertView;
    }


}
