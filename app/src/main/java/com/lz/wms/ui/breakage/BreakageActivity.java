package com.lz.wms.ui.breakage;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.api.ResponseBreakageType;
import com.lz.wms.entity.api.ResponseWarehouseType;
import com.lz.wms.ui.outbound.OutTypeAdapter;
import com.lz.wms.ui.outbound.OutboundViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.breakage)
public class BreakageActivity extends BaseActivity<BreakageViewModel> {
    @BindView(R.id.spinner_breakage_type)
    Spinner breakageType;
    @BindView(R.id.spinner_warehouse)
    Spinner warehouseType;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_breakage;
    }

    @Override
    protected void initView() {
        title.setText("报损管理");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    protected void initObserver() {
        viewModel.breakageType.observe(this, new Observer<List<ResponseBreakageType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseBreakageType.ResultBean> datas) {
                if (datas!=null){
                    breakageType.setAdapter(new BreakageAdapter(datas));
                }
            }
        });
        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> datas) {
                if (datas!=null){
                    warehouseType.setAdapter(new ArrayAdapter<ResponseWarehouseType.ResultBean>(BreakageActivity.this,android.R.layout.simple_list_item_1,datas));
                }
            }
        });

    }
    @OnClick(R.id.btn_add_supplies)
    public void addSupplies() {
        ARouter.getInstance().build(RouterTable.addBreakage).navigation();
    }

}
