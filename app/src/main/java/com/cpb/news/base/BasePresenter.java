package com.cpb.news.base;

import android.support.annotation.NonNull;

import com.cpb.news.callback.RequestCallBack;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: BasePresenter
 */

public class BasePresenter<V extends IBaseView, T> implements IBasePresenter,RequestCallBack<T> {

    protected V mView;

    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(@NonNull IBaseView view) {
        mView = (V)view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onBefore() {
        mView.showProgress();
    }

    @Override
    public void onSuccess(T data) {
        mView.hideProgress();
    }

    @Override
    public void onError(String errorMsg) {
        mView.hideProgress();
        mView.showMsg(errorMsg);
    }
}
