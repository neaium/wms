package com.lz.wms.ui.breakage;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.api.ResponseBreakageType;
import com.lz.wms.ui.outbound.OutTypeAdapter;
import com.lz.wms.ui.outbound.OutboundViewModel;

import java.util.List;

import butterknife.BindView;

@Route(path = RouterTable.breakage)
public class BreakageActivity extends BaseActivity<BreakageViewModel> {
    @BindView(R.id.spinner_breakage_type)
    Spinner breakageType;


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

    }
}
