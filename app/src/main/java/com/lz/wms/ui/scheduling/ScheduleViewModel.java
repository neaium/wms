package com.lz.wms.ui.scheduling;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;

import com.lz.wms.base.BaseViewModel;
import com.lz.wms.entity.api.ResponseWarehouseType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ScheduleViewModel extends BaseViewModel {
    public MutableLiveData<List<ResponseWarehouseType.ResultBean>> warehouseType = new MutableLiveData<>();
    public MutableLiveData<List<ResponseWarehouseType.ResultBean>> newWarehouseType = new MutableLiveData<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void OnStart() {
        getWarehouseType();
        getNewWarehouseType();
    }
    private void getNewWarehouseType() {
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
}
