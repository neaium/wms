package com.lz.wms.ui.inbound;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.api.ResponseInType;

import java.util.List;

import butterknife.BindView;

@Route(path = RouterTable.inbound)
public class InboundActivity extends BaseActivity<InboundViewModel> {
    @BindView(R.id.spinner_inbound_type)
    Spinner inType;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_inbound;
    }

    @Override
    protected void initView() {
        title.setText("新增入库单");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
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
    }
}
