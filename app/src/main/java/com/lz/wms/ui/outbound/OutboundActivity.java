package com.lz.wms.ui.outbound;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;

@Route(path = RouterTable.outbound)
public class OutboundActivity extends BaseActivity<BaseViewModel> {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_outbound;
    }

    @Override
    protected void initView() {
        title.setText("出库管理");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this,R.color.white));

    }

    @Override
    protected void initObserver() {

    }
}
