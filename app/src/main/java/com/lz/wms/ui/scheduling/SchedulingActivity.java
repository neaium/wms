package com.lz.wms.ui.scheduling;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.api.ResponseWarehouseType;
import com.lz.wms.ui.movement.MovementActivity;

import java.util.List;

import butterknife.BindView;

@Route(path = RouterTable.scheduling)
public class SchedulingActivity extends BaseActivity<ScheduleViewModel> {
    @BindView(R.id.warehouse_original)
    Spinner warehouse_original;
    @BindView(R.id.warehouse_target)
    Spinner warehouse_target;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_scheduling;
    }

    @Override
    protected void initView() {
        title.setText("调度管理");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    protected void initObserver() {
        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> datas) {
                if (datas != null) {
                    warehouse_original.setAdapter(new ArrayAdapter<ResponseWarehouseType.ResultBean>(SchedulingActivity.this, android.R.layout.simple_list_item_1, datas));
                }
            }
        });

        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> datas) {
                if (datas != null) {
                    warehouse_target.setAdapter(new ArrayAdapter<ResponseWarehouseType.ResultBean>(SchedulingActivity.this, android.R.layout.simple_list_item_1, datas));
                }
            }
        });
    }
}
