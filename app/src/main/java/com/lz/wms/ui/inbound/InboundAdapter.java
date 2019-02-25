package com.lz.wms.ui.inbound;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lz.wms.R;
import com.lz.wms.entity.InboundItem;

import java.util.ArrayList;
import java.util.List;

public class InboundAdapter extends BaseAdapter {
    public List<InboundItem> datas=new ArrayList<>();

    public InboundAdapter() {
    }

    public void addData(InboundItem item){
        datas.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public InboundItem getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh;
        InboundItem item=getItem(position);
        if(view==null){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.supplies_item,parent,false);
            vh=new ViewHolder(view);
        }else{
            vh= (ViewHolder) view.getTag();
        }
        vh.productName.setText("物资名称"+item.ProductName);
        vh.count.setText("数量"+item.Size);
        vh.loaction.setText("入库库位"+item.LocalNum);
        vh.batch.setText("物资批次"+item.BatchNum);
        return view;
    }

    public static final class ViewHolder{
        public TextView productName,count,loaction,batch;
        public ViewHolder(View v) {
            productName=v.findViewById(R.id.product_name);
            count=v.findViewById(R.id.count);
            loaction=v.findViewById(R.id.loaction);
            batch=v.findViewById(R.id.batch);
            v.setTag(this);
        }
    }
}
