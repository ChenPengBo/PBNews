package com.cpb.news.base;

import android.support.annotation.NonNull;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述: IPresenter
 */

public interface IPresenter {
    void onCreate();

    void attachView(@NonNull IBaseView view);

    void onDestroy();
}
