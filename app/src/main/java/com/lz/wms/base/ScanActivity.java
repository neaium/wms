package com.lz.wms.base;

public abstract class ScanActivity extends BaseActivity {

    /**
     * 扫描到条码
     * @param code 条码内容
     */
    abstract void onScan(String code);
}
