package com.lz.wms.ui.login;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;

import com.alibaba.android.arouter.launcher.ARouter;

import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.DialogMessage;
import com.lz.wms.entity.api.RequestLogin;
import com.lz.wms.entity.api.ResponseLogin;
import com.lz.wms.entity.api.ResponseOutType;
import com.lz.wms.entity.api.ResponseWarehouseType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<List<ResponseWarehouseType.ResultBean>> warehouseType = new MutableLiveData<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        getWarehouseType();
    }

    private void getWarehouseType() {
        api.getWarehouseType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseWarehouseType>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseWarehouseType responseWarehouseType) {
                        if (responseWarehouseType.code == 1) {
                            warehouseType.postValue(responseWarehouseType.Result);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void login(String username, String password) {
        api.login(new RequestLogin(username, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseLogin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseLogin responseLogin) {
                        if (responseLogin.code == 0) {
                            ARouter.getInstance().build(RouterTable.menu).navigation();
                            finishMutableLiveData.postValue(true);
                        } else {
                            dialogMessageMutableLiveData.postValue(new DialogMessage(responseLogin.message));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialogMessageMutableLiveData.postValue(new DialogMessage("接口异常：" + e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
