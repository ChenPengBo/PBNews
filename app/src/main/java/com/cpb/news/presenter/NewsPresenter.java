package com.cpb.news.presenter;

import com.cpb.news.base.BasePresenter;
import com.cpb.news.contract.NewsContract;
import com.cpb.news.entity.NewsChannel;

import java.util.List;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述:
 */

public class NewsPresenter extends BasePresenter<NewsContract.IView,List<NewsChannel>> implements NewsContract.IPresenter {

    @Override
    public void onChannelDbChanged() {

    }
}
