package com.cpb.news.callback;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: 请求回调
 */

public interface RequestCallBack<T> {

    void onBefore();

    void onSuccess(T data);

    void onError(String errorMsg);
}
