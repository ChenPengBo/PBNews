package com.cpb.news.di.component;

import android.app.Activity;
import android.content.Context;

import com.cpb.news.di.module.ActivityModule;
import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerActivity;

import dagger.Component;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

}
