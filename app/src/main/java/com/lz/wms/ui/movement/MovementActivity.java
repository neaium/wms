package com.lz.wms.ui.movement;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.api.ResponseWarehouseType;
import com.lz.wms.ui.breakage.BreakageActivity;

import java.util.List;

import butterknife.BindView;

@Route(path = RouterTable.movement)
public class MovementActivity extends BaseActivity<MovementViewModel> {
    @BindView(R.id.spinner_warehouse)
    Spinner warehouseType;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_movement;
    }

    @Override
    protected void initView() {
        title.setText("移库管理");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    protected void initObserver() {
        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> datas) {
                if (datas != null) {
                    warehouseType.setAdapter(new ArrayAdapter<ResponseWarehouseType.ResultBean>(MovementActivity.this, android.R.layout.simple_list_item_1, datas));
                }
            }
        });

    }
}
