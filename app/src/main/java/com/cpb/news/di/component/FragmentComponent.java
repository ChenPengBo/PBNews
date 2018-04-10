package com.cpb.news.di.component;

import android.app.Activity;
import android.content.Context;

import com.cpb.news.di.module.FragmentModule;
import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerFragment;

import dagger.Component;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();


}
