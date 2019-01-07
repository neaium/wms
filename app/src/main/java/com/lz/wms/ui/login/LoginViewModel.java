package com.lz.wms.ui.login;


import com.alibaba.android.arouter.launcher.ARouter;

import com.lz.wms.base.BaseViewModel;
import com.lz.wms.config.RouterTable;
import com.lz.wms.entity.DialogMessage;
import com.lz.wms.entity.RequestLogin;
import com.lz.wms.entity.ResponseLogin;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {

    public void login(String username,String password,int type){
        api.login(new RequestLogin(username,password,type))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseLogin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseLogin responseLogin) {
                        if(responseLogin.code==1){
                            ARouter.getInstance().build(RouterTable.menu).navigation();
                            finishMutableLiveData.postValue(true);
                        }else{
                            dialogMessageMutableLiveData.postValue(new DialogMessage(responseLogin.msg));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialogMessageMutableLiveData.postValue(new DialogMessage("接口异常："+e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
