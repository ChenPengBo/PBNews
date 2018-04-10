package com.cpb.news.di.module;

import android.app.Activity;
import android.content.Context;

import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context ProvideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Activity ProvideActivity() {
        return mActivity;
    }
}
