package com.lz.wms.ui.scheduling;

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

@Route(path = RouterTable.addScheduling)
public class AddScheduleActivity extends BaseActivity<InboundViewModel> {
    @BindView(R.id.schedule_name)
    EditText schedule_name;
    @BindView(R.id.specifications)
    EditText specifications;
    @BindView(R.id.date)
    EditText date;
    @BindView(R.id.schedule_quantity)
    EditText schedule_quantity;
    @BindView(R.id.add_date)
    EditText add_date;
    @BindView(R.id.localNum)
    Spinner localNum;


    InboundItem data = new InboundItem();

    @Override
    protected int getLayoutResId() {
        return R.layout.add_scheduling_supplies;
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
        if (schedule_name.getText().length() == 0) {
            showDialog("物资名称不能为空");
        } else if (specifications.getText().length() == 0) {
            showDialog("规格不能为空");
        } else if (date.getText().length() == 0) {
            showDialog("检定期不能为空");
        } else if (schedule_quantity.getText().length() == 0) {
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
