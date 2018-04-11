package com.cpb.news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cpb.news.App;
import com.cpb.news.R;
import com.cpb.news.di.component.ActivityComponent;
import com.cpb.news.di.component.DaggerActivityComponent;
import com.cpb.news.di.module.ActivityModule;
import com.cpb.news.util.NetWorkUtil;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述: Activity基类
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {

    protected P mPresenter;
    private ActivityComponent mActivityComponent;

    protected ImmersionBar mImmersionBar;

    public abstract int getLayoutId();

    public abstract void initViews();

    public abstract void initInjector();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //检查网络是否可用
        if (!NetWorkUtil.isNetworkAvailable()) {
            Toast.makeText(this, getString(R.string.internet_error),
                    Toast.LENGTH_SHORT).show();
        }

        initActivityComponent();

        setContentView(getLayoutId());
        ButterKnife.bind(this);

        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        initInjector();

        initViews();
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mImmersionBar.hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR).init();
    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar
                .fullScreen(true)
                .transparentBar()
                .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                .init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

        if (mImmersionBar != null) {
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态}
        }
    }
}
