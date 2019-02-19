package com.lz.wms.ui.login;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.LoginType;
import com.lz.wms.entity.api.ResponseOutType;
import com.lz.wms.entity.api.ResponseWarehouseType;
import com.lz.wms.ui.outbound.OutTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.inflate;

@Route(path = RouterTable.login)
public class LoginActivity extends BaseActivity<LoginViewModel> {
    @BindView(R.id.edit_name)
    EditText userName;
    @BindView(R.id.edit_pwd)
    EditText password;
    @BindView(R.id.login_type)
    Spinner type;
    LoginTypeAdapter loginTypeAdapter;

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
        viewModel.warehouseType.observe(this, new Observer<List<ResponseWarehouseType.ResultBean>>() {
            @Override
            public void onChanged(@Nullable List<ResponseWarehouseType.ResultBean> data) {
                if(data!=null){
                    type.setAdapter(new LoginTypeAdapter(data));

                }
            }
        });

    }

    @OnClick(R.id.login_btn)
    public void login() {
     //   String SnNum = loginTypeAdapter.getItem(type.getSelectedItemPosition()).SnNum;
        if (userName.getText().length() == 0) {
            showDialog("请填写用户名!");
        } else if (password.getText().length() == 0) {
            showDialog("请填写密码!");
        }/* else if (SnNum==null) {
            showDialog("请选择仓库!");
        }*/ else {

            viewModel.login(userName.getText().toString(), password.getText().toString());
        }
    }

    @OnClick(R.id.set)
    public void setting() {
        ARouter.getInstance().build(RouterTable.setting).navigation();
    }

}
