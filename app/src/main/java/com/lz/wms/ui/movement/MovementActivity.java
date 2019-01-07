package com.lz.wms.ui.movement;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;

@Route(path = RouterTable.movement)
public class MovementActivity extends BaseActivity<BaseViewModel> {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_breakage;
    }

    @Override
    protected void initView() {
        title.setText("移库管理");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    protected void initObserver() {

    }
}
