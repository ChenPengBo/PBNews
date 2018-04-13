package com.cpb.news;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cpb.news.dao.DaoMaster;
import com.cpb.news.dao.DaoSession;
import com.cpb.news.db.DBHelper;
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

    private DBHelper mDbHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initApplicationComponent();
        initDatabase();
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initDatabase() {
        mDbHelper = new DBHelper(this, "pb-news-db", null);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
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

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
