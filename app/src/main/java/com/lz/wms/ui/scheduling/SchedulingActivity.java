package com.lz.wms.ui.scheduling;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;

@Route(path = RouterTable.scheduling)
public class SchedulingActivity extends BaseActivity<BaseViewModel> {


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

    }
}
