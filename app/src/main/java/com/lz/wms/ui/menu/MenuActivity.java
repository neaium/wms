package com.lz.wms.ui.menu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.menu)
public class MenuActivity extends BaseActivity<BaseViewModel> {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_menu;
    }

    @Override
    protected void initView() {
        title.setText("云联三方仓储管理系统");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    protected void initObserver() {

    }

    @OnClick(R.id.menu_scheduling)
    public void setMenu_scheduling() {
        ARouter.getInstance().build(RouterTable.scheduling).navigation();
    }

    @OnClick(R.id.menu_outbound)
    public void setMenu_outbound() {
        ARouter.getInstance().build(RouterTable.outbound).navigation();
    }

    @OnClick(R.id.menu_movement)
    public void setMenu_movement() {
        ARouter.getInstance().build(RouterTable.movement).navigation();
    }

    @OnClick(R.id.menu_inbound)
    public void setMenu_inbound() {
        ARouter.getInstance().build(RouterTable.inbound).navigation();
    }

    @OnClick(R.id.menu_breakage)
    public void setMenu_breakage() {
        ARouter.getInstance().build(RouterTable.breakage).navigation();
    }

    @OnClick(R.id.menu_check)
    public void setMenu_check() {
        ARouter.getInstance().build(RouterTable.check).navigation();
    }
}
