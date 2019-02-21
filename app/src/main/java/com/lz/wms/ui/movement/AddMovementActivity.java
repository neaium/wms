package com.lz.wms.ui.movement;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.InboundItem;
import com.lz.wms.ui.inbound.InboundViewModel;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.addMovement)
public class AddMovementActivity extends BaseActivity<InboundViewModel> {
    @BindView(R.id.movement_name)
    EditText movement_name;
    @BindView(R.id.specifications)
    EditText specifications;
    @BindView(R.id.date)
    EditText date;
    @BindView(R.id.movement_quantity)
    EditText movement_quantity;
    @BindView(R.id.add_date)
    EditText add_date;
    @BindView(R.id.localNum)
    Spinner localNum;


    InboundItem data = new InboundItem();

    @Override
    protected int getLayoutResId() {
        return R.layout.add_movement_supplies;
    }

    @Override
    protected void initView() {
        title.setText("新增表单");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));

    }

    @Override
    protected void initObserver() {

    }

    @OnClick(R.id.btn_ok)
    public void add() {
        //TODO 验证数据完整
        if (movement_name.getText().length() == 0) {
            showDialog("物资名称不能为空");
        } else if (specifications.getText().length() == 0) {
            showDialog("规格不能为空");
        } else if (date.getText().length() == 0) {
            showDialog("检定期不能为空");
        } else if (movement_quantity.getText().length() == 0) {
            showDialog("数量不能为空");
        } else if (add_date.getText().length() == 0) {
            showDialog("物资批次不能为空");
        } else {
            Intent intent = new Intent();
            intent.putExtra("data", data);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
