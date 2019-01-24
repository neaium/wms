package com.lz.wms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import com.lz.wms.config.RouterTable;

/**
 * @author Neaium
 * 初始化活动
 */
public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(RouterTable.menu).navigation();
        finish();
    }
}
