package com.lz.wms.ui.inbound;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.lz.wms.base.BaseViewModel;
import com.lz.wms.entity.InboundItem;
import com.lz.wms.entity.api.RequestAdd;
import com.lz.wms.entity.api.ResponseAdd;
import com.lz.wms.entity.api.ResponseInType;
import com.lz.wms.entity.api.ResponseWarehouseType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class InboundViewModel extends BaseViewModel {
    public MutableLiveData<List<ResponseInType.ResultBean>> inType=new MutableLiveData<>();
    public MutableLiveData<List<ResponseWarehouseType.ResultBean>> warehouseType=new MutableLiveData<>();


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        getInType();
        getWarehouse();
    }
    private void getInType(){
        api.getInTypeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseInType>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseInType responseInType) {
                        if(responseInType.code==1){
                            inType.postValue(responseInType.Result);
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

    private void getWarehouse(){
        api.getWarehouseType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseWarehouseType>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseWarehouseType responseWarehouseType) {
                        if(responseWarehouseType.code==1){
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
    public void add(List<InboundItem> items){
        api.add(new RequestAdd("","",0,"","",items))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseAdd>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseAdd response) {
                        Log.e("onNext",response.code+response.message+response.Result);
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
