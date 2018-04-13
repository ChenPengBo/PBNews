package com.cpb.news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpb.news.App;
import com.cpb.news.di.component.DaggerFragmentComponent;
import com.cpb.news.di.component.FragmentComponent;
import com.cpb.news.di.module.FragmentModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: BaseFragment
 */

public abstract class BaseFragment<P extends IBasePresenter> extends Fragment {

    protected FragmentComponent mFragmentComponent;

    protected P mPresenter;

    private View mRootView;

    Unbinder unbinder;

    public abstract void initViews(View view);

    public abstract void initInjector();

    public abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentComponent();
        initInjector();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, mRootView);
            initViews(mRootView);
        }
        return mRootView;
    }

    private void initFragmentComponent() {
        mFragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

        unbinder.unbind();
    }
}
