package com.lz.wms.ui.inbound;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;

import com.lz.wms.base.BaseViewModel;
import com.lz.wms.entity.api.ResponseInType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class InboundViewModel extends BaseViewModel {
    public MutableLiveData<List<ResponseInType.ResultBean>> inType=new MutableLiveData<>();


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        getInType();
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
}
