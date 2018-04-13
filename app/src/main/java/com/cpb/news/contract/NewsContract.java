package com.cpb.news.contract;

import com.cpb.news.base.IBasePresenter;
import com.cpb.news.base.IBaseView;
import com.cpb.news.callback.RequestCallBack;
import com.cpb.news.entity.NewsChannel;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述:
 */

public class NewsContract {

    public interface IView extends IBaseView{
        void initViewPager(List<NewsChannel> newsChannels);
    }

    public interface IPresenter extends IBasePresenter {
        void onChannelDbChanged();
    }

    public interface IInteractor<T>{
        Disposable loadChannel(RequestCallBack<T> callBack);
    }

}
