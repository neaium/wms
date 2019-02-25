package com.lz.wms.base;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.ParameterizedType;

import com.lz.wms.R;
import com.lz.wms.entity.DialogMessage;

import butterknife.ButterKnife;

/**
 * @author neaium
 */
public abstract class BaseActivity<VM extends BaseViewModel> extends AppCompatActivity {
    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initObserver();

    protected VM viewModel;
    protected AlertDialog messageDiaog;
    protected @Nullable
    TextView title;
    protected @Nullable
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasTitleBar()) {
            LinearLayout root = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
            View child = getLayoutInflater().inflate(getLayoutResId(), null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
            layoutParams.weight = 1;
            child.setLayoutParams(layoutParams);
            root.addView(child);
            setContentView(root);
            title = findViewById(R.id.toolbar_title);
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            setContentView(getLayoutResId());
        }
        ButterKnife.bind(this);
        mInitView();
        viewModel = ViewModelProviders.of(this).get(getVMClass());
        getLifecycle().addObserver(viewModel);
        mInitObserver();
    }

    private void mInitView() {
        messageDiaog = new AlertDialog.Builder(this).setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();
        initView();
    }

    private void mInitObserver() {
        viewModel.dialogMessageMutableLiveData.observe(this, new Observer<DialogMessage>() {
            @Override
            public void onChanged(@Nullable DialogMessage dialogMessage) {
                if (dialogMessage != null) {
                    showDialog(dialogMessage.message);
                }
            }
        });
        viewModel.finishMutableLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean finish) {
                if (finish != null && finish) {
                    finish();
                }
            }
        });
        initObserver();
    }

    protected void showDialog(String message){
        messageDiaog.setMessage(message);
        messageDiaog.show();
    }

    private final Class<VM> getVMClass() {
        Class<VM> tClass = (Class<VM>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    protected boolean hasTitleBar() {
        return true;
    }

}
