package com.cpb.news.interactor;

import com.cpb.news.callback.RequestCallBack;
import com.cpb.news.contract.NewsContract;
import com.cpb.news.entity.NewsChannel;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述:
 */

public class NewsInteractor implements NewsContract.IInteractor<List<NewsChannel>> {
    @Override
    public Disposable loadChannel(RequestCallBack<List<NewsChannel>> callBack) {
        // TODO: 2018/4/13 待改
//        return Observable.create(new ObservableOnSubscribe<List<NewsChannel>>() {
//
//            @Override
//            public void subscribe(ObservableEmitter<List<NewsChannel>> emitter) throws Exception {
//
//            }
//        }).subscribe(new Observer<List<NewsChannel>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(List<NewsChannel> newsChannels) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        return null;
    }
}
