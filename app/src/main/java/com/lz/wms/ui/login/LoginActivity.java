package com.lz.wms.ui.login;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.DialogMessage;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.login)
public class LoginActivity extends BaseActivity<LoginViewModel> {
    @BindView(R.id.edit_name)
    EditText userName;
    @BindView(R.id.edit_pwd)
    EditText password;
    @BindView(R.id.login_type)
    Spinner type;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean hasTitleBar() {
        return false;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initObserver() {

    }

    @OnClick(R.id.login_btn)
    public void login() {
        viewModel.login(userName.getText().toString(),password.getText().toString(),0);
    }

    @OnClick(R.id.set)
    public void setting() {
        ARouter.getInstance().build(RouterTable.setting).navigation();
    }

}
