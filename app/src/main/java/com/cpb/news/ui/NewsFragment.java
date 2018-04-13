package com.cpb.news.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.cpb.news.R;
import com.cpb.news.base.BaseFragment;
import com.cpb.news.contract.NewsContract;
import com.cpb.news.entity.NewsChannel;

import java.util.List;

import butterknife.BindView;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: 新闻模块
 */

public class NewsFragment extends BaseFragment implements NewsContract.IView{

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.iv_channel_add)
    ImageView mIvChannelAdd;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {

    }

    @Override
    public void initViewPager(List<NewsChannel> newsChannels) {

    }
}
