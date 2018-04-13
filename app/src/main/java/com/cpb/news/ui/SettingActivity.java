package com.cpb.news.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.cpb.news.R;
import com.cpb.news.base.BaseActivity;

import butterknife.BindView;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: 设置
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initViews() {
        setSupportActionBar(mToolbar);
    }

    @Override
    public void initInjector() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(mToolbar).init();
    }

    /**
     * 跳转到
     *
     * @param activity
     */
    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, SettingActivity.class));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
        return true;
    }
}
