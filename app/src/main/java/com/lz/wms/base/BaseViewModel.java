package com.lz.wms.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.lz.wms.entity.DialogMessage;
import com.lz.wms.net.Api;
import com.lz.wms.net.RetrofitProvider;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<DialogMessage> dialogMessageMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<Boolean> finishMutableLiveData=new MutableLiveData<>();
    protected Api api=RetrofitProvider.getApi();
}
