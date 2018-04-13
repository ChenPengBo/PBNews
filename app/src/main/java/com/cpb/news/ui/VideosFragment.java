package com.cpb.news.ui;

import android.view.View;

import com.cpb.news.R;
import com.cpb.news.base.BaseFragment;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: 视频模块
 */

public class VideosFragment extends BaseFragment {

    public static VideosFragment newInstance() {
        return new VideosFragment();
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
        return R.layout.fragment_videos;
    }
}
