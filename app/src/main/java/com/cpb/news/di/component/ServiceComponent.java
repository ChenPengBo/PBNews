package com.cpb.news.di.component;

import android.content.Context;

import com.cpb.news.di.module.ServiceModule;
import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerService;

import dagger.Component;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
    @ContextLife("Service")
    Context getServiceContext();

    @ContextLife("Application")
    Context getApplicationContext();
}
