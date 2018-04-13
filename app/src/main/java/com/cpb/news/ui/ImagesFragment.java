package com.cpb.news.ui;

import android.view.View;

import com.cpb.news.R;
import com.cpb.news.base.BaseFragment;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: 图片模块
 */

public class ImagesFragment extends BaseFragment {

    public static ImagesFragment newInstance() {
        return new ImagesFragment();
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
        return R.layout.fragment_images;
    }
}
