package com.lz.wms.ui.breakage;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;

import com.lz.wms.base.BaseViewModel;
import com.lz.wms.entity.api.ResponseBreakageType;
import com.lz.wms.entity.api.ResponseInType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BreakageViewModel extends BaseViewModel {
    public MutableLiveData<List<ResponseBreakageType.ResultBean>> breakageType = new MutableLiveData<>();


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        getBreakageType();
    }

    private void getBreakageType() {
        api.getBreakageTypeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBreakageType>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBreakageType responseBreakageType) {
                        if (responseBreakageType.code==1){
                            breakageType.postValue(responseBreakageType.Result);

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
