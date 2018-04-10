package com.cpb.news.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.cpb.news.di.scope.ContextLife;
import com.cpb.news.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Fragment provideFragment() {
        return mFragment;
    }
}
