package com.lz.wms.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.wms.R;
import com.lz.wms.base.BaseActivity;
import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.ui.login.LoginActivity;

import java.io.BufferedReader;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterTable.setting)
public class SettingActivity extends BaseActivity<BaseViewModel> {
    @BindView(R.id.remember)
    CheckBox remember;
    @BindView(R.id.address)
    EditText addressEdit;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        pref=PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember=pref.getBoolean("remember_address",false);
        if (isRemember){
            String address=pref.getString("address","");
            addressEdit.setText(address);
            remember.setChecked(true);
        }
        title.setText("设置");
        title.setTextSize(18f);
        title.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @OnClick(R.id.save)
    public void saving(){
        String address=addressEdit.getText().toString();
        editor=pref.edit();
        if (remember.isChecked()){
            editor.putBoolean("remember_address",true);
            editor.putString("address",address);
        }else {
            editor.clear();
        }
        editor.apply();
        finish();

    }
    @Override
    protected void initObserver() {

    }


}
