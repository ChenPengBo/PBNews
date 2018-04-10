package com.cpb.news.di.module;

import android.content.Context;

import com.cpb.news.App;
import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@Module
public class ApplicationModule {
    private App mApplication;

    public ApplicationModule(App application) {
        mApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
