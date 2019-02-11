package com.lz.wms.ui.outbound;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lz.wms.entity.api.ResponseOutType;

import java.util.List;

import okhttp3.Response;

public class OutTypeAdapter extends BaseAdapter {


    private List<ResponseOutType.ResultBean> datas;

    public OutTypeAdapter(List<ResponseOutType.ResultBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public ResponseOutType.ResultBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        }
        TextView tv= (TextView) convertView;
        tv.setText(getItem(position).Description);
        return convertView;
    }
}
