package com.cpb.news.base;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.cpb.news.App;
import com.cpb.news.R;
import com.cpb.news.di.component.ActivityComponent;
import com.cpb.news.di.component.DaggerActivityComponent;
import com.cpb.news.di.module.ActivityModule;
import com.cpb.news.util.NetWorkUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.ButterKnife;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述: Activity基类
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {

    protected P mPresenter;
    private ActivityComponent mActivityComponent;

    protected Toolbar mToolbar;

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
        initSystemBarTint();
        setStatusBarTranslucent();

        setContentView(getLayoutId());
        ButterKnife.bind(this);

        initInjector();
        //initToolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

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

    /**
     * 设置状态栏颜色
     */
    protected void initSystemBarTint() {
        // 设置状态栏全透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    //colorPrimaryDark
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setStatusBarTranslucent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimary);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }
}
