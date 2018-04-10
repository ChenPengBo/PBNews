package com.cpb.news.di.component;

import android.content.Context;

import com.cpb.news.di.module.ApplicationModule;
import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerApp;

import dagger.Component;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}