package com.lz.wms.ui.outbound;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.api.ResponseInType;
import com.lz.wms.entity.api.ResponseOutType;
import com.lz.wms.entity.api.ResponseWarehouseType;
import com.lz.wms.ui.inbound.InTypeAdapter;
import com.lz.wms.ui.inbound.InboundActivity;

import java.util.List;

import butterknife.BindView;

@Route(path = RouterTable.outbound)
public class OutboundActivity extends BaseActivity<OutboundViewModel> {
    @BindView(R.id.spinner_outbound_type)
    Spinner outType;
    @BindView(R.id.outbound_spinner_warehouse)
    Spinner warehouseType;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_outbound;
    }

    @Override
    protected void initView() {
        title.setText("出库管理");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));

    }


    @Override
    protected void initObserver() {
        viewModel.outType.observe(this, new Observer<List<ResponseOutType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseOutType.ResultBean> data) {
                if (data != null) {
                    outType.setAdapter(new OutTypeAdapter(data));

                }
            }
        });
        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> data) {
                if (data != null) {
                    warehouseType.setAdapter(new ArrayAdapter<ResponseWarehouseType.ResultBean>(OutboundActivity.this, android.R.layout.simple_list_item_1, data));
                }
            }
        });
    }
}

