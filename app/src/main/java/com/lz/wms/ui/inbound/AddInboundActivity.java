package com.lz.wms.ui.inbound;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.TypeAdapter;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.InboundItem;
import com.lz.wms.entity.api.ResponseInType;
import com.lz.wms.entity.api.ResponsePositionType;
import com.lz.wms.entity.api.ResponseWarehouseType;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.addInbound)
public class AddInboundActivity extends BaseActivity<AddInboundViewModel> {
    @BindView(R.id.spinner_inbound_type)
    EditText barcode;
    @BindView(R.id.inbound_name)
    EditText inbound_name;
    @BindView(R.id.specifications)
    EditText specifications;
    @BindView(R.id.date)
    EditText LastTime;
    @BindView(R.id.inbound_quantity)
    EditText Size;
    @BindView(R.id.add_date)
    EditText add_date;
    @BindView(R.id.localNum)
    Spinner localNum;




    @Override
    protected int getLayoutResId() {
        return R.layout.add_inbound_supplies;
    }

    @Override
    protected void initView() {
        title.setText("新增表单");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));

    }

    @Override
    protected void initObserver() {
        viewModel.positionType.observe(this, new Observer<List<ResponsePositionType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponsePositionType.ResultBean> data) {
                if(data!=null){
                    localNum.setAdapter(new ArrayAdapter<ResponsePositionType.ResultBean>(AddInboundActivity.this,android.R.layout.simple_list_item_1,data));
                }
            }


        });

    }

    @OnClick(R.id.btn_ok)
    public void add() {
        //TODO 验证数据完整
        if (inbound_name.getText().length() == 0) {
            showDialog("物资名称不能为空");
        } else if (specifications.getText().length() == 0) {
            showDialog("规格不能为空");
        } else if (LastTime.getText().length() == 0) {
            showDialog("检定期不能为空");
        } else if (Size.getText().length() == 0) {
            showDialog("数量不能为空");
        } else if (add_date.getText().length() == 0) {
            showDialog("物资批次不能为空");
        } else {
            InboundItem data = new InboundItem();
            data.ProductNum=barcode.getText().toString();
            data.ProductName=inbound_name.getText().toString();
            data.BatchNum=add_date.getText().toString();
            data.LastTime=LastTime.getText().toString();
            data.Size=Size.getText().toString();
            data.LocalNum=((ResponsePositionType.ResultBean)localNum.getSelectedItem()).LocalNum;

            Intent intent = new Intent();
            intent.putExtra("data", data);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
