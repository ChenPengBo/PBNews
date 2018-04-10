package com.cpb.news;

import android.app.Application;
import android.content.Context;

import com.cpb.news.di.component.ApplicationComponent;
import com.cpb.news.di.component.DaggerApplicationComponent;
import com.cpb.news.di.module.ApplicationModule;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述: App
 */

public class App extends Application {

    private static App instance;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public static Context getContext(){
        synchronized (App.class) {
            return instance.getApplicationContext();
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
