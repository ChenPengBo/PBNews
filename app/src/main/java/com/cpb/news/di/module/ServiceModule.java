package com.cpb.news.di.module;

import android.app.Service;
import android.content.Context;

import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerService;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@Module
public class ServiceModule {
    private Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

    @Provides
    @PerService
    @ContextLife("Service")
    public Context ProvideServiceContext() {
        return mService;
    }
}
