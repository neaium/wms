package com.lz.wms.ui.inbound;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.InboundItem;
import com.lz.wms.entity.api.ResponseInType;
import com.lz.wms.entity.api.ResponseWarehouseType;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.inbound)
public class InboundActivity extends BaseActivity<InboundViewModel> {
    @BindView(R.id.spinner_inbound_type)
    Spinner inType;
    @BindView(R.id.spinner_Warehouse)
    Spinner warehouse;
    @BindView(R.id.second_list_view)
    ListView listView;
    InboundAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_inbound;
    }

    @Override
    protected void initView() {
        title.setText("新增入库单");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
        adapter=new InboundAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    protected void initObserver() {
        viewModel.inType.observe(this, new Observer<List<ResponseInType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseInType.ResultBean> data) {
                if(data!=null){
                    inType.setAdapter(new InTypeAdapter(data));
                }
            }
        });
        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> data) {
                if(data!=null){
                    warehouse.setAdapter(new ArrayAdapter<ResponseWarehouseType.ResultBean>(InboundActivity.this,android.R.layout.simple_list_item_1,data));
                }
            }
        });
    }
    @OnClick(R.id.btn_add_supplies)
    public void addSupplies() {
        ARouter.getInstance().build(RouterTable.addInbound).navigation(this,88);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==88&&resultCode==RESULT_OK){
            InboundItem item= (InboundItem) data.getSerializableExtra("data");
            adapter.addData(item);
        }
    }

    @OnClick(R.id.btn_save)
    public void save() {
        viewModel.add(adapter.datas);
    }
}
