package com.cpb.news.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.cpb.news.R;
import com.cpb.news.base.BaseActivity;
import com.cpb.news.common.AppConstants;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private NewsFragment newsFragment;
    private ImagesFragment imagesFragment;
    private VideosFragment videosFragment;
    private FavoriteFragment favoriteFragment;
    private ToolsFragment toolsFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment(savedInstanceState);
    }

    /**
     * 初始化fragment
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            newsFragment = (NewsFragment) getSupportFragmentManager().getFragment(savedInstanceState, AppConstants.NEWS_FRAGMENT);
            imagesFragment = (ImagesFragment) getSupportFragmentManager().getFragment(savedInstanceState, AppConstants.IMAGES_FRAGMENT);
            videosFragment = (VideosFragment) getSupportFragmentManager().getFragment(savedInstanceState, AppConstants.VIDEOS_FRAGMENT);
            favoriteFragment = (FavoriteFragment) getSupportFragmentManager().getFragment(savedInstanceState, AppConstants.FAVORITE_FRAGMENT);
            toolsFragment = (ToolsFragment) getSupportFragmentManager().getFragment(savedInstanceState, AppConstants.TOOLS_FRAGMENT);
        } else {
            newsFragment = NewsFragment.newInstance();
            imagesFragment = ImagesFragment.newInstance();
            videosFragment = VideosFragment.newInstance();
            favoriteFragment = FavoriteFragment.newInstance();
            toolsFragment = ToolsFragment.newInstance();
        }

        if (!newsFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content, newsFragment, AppConstants.NEWS_FRAGMENT)
                    .commit();
        }

        if (!imagesFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content, imagesFragment, AppConstants.IMAGES_FRAGMENT)
                    .commit();
        }

        if (!videosFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content, videosFragment, AppConstants.VIDEOS_FRAGMENT)
                    .commit();
        }

        if (!favoriteFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content, favoriteFragment, AppConstants.FAVORITE_FRAGMENT)
                    .commit();
        }

        if (!toolsFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content, toolsFragment, AppConstants.TOOLS_FRAGMENT)
                    .commit();
        }

        /**
         * 第一次加载显示新闻
         */
        showNewsFrament();
    }

    /**
     * 新闻模块
     */
    private void showNewsFrament() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(newsFragment);
        fragmentTransaction.hide(imagesFragment);
        fragmentTransaction.hide(videosFragment);
        fragmentTransaction.hide(favoriteFragment);
        fragmentTransaction.hide(toolsFragment);
        fragmentTransaction.commit();
        mToolbar.setTitle(getResources().getString(R.string.nav_news));
    }

    /**
     * 图片模块
     */
    private void showImagesFrament() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(imagesFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(videosFragment);
        fragmentTransaction.hide(favoriteFragment);
        fragmentTransaction.hide(toolsFragment);
        fragmentTransaction.commit();
        mToolbar.setTitle(getResources().getString(R.string.nav_images));
    }

    /**
     * 视频模块
     */
    private void showVideosFrament() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(videosFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(imagesFragment);
        fragmentTransaction.hide(favoriteFragment);
        fragmentTransaction.hide(toolsFragment);
        fragmentTransaction.commit();
        mToolbar.setTitle(getResources().getString(R.string.nav_videos));
    }

    /**
     * 收藏模块
     */
    private void showFavoriteFrament() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(favoriteFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(imagesFragment);
        fragmentTransaction.hide(videosFragment);
        fragmentTransaction.hide(toolsFragment);
        fragmentTransaction.commit();
        mToolbar.setTitle(getResources().getString(R.string.nav_favorites));
    }

    /**
     * 百宝箱模块
     */
    private void showToolsFrament() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(toolsFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(imagesFragment);
        fragmentTransaction.hide(videosFragment);
        fragmentTransaction.hide(favoriteFragment);
        fragmentTransaction.commit();
        mToolbar.setTitle(getResources().getString(R.string.nav_tools));
    }

    @Override
    public void initViews() {
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            //将侧边栏顶部延伸至status bar
            mDrawerLayout.setFitsSystemWindows(true);
            //将主页面顶部延伸至status bar
            mDrawerLayout.setClipToPadding(false);
        }

        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(mToolbar).init();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_news:
                showNewsFrament();
                break;
            case R.id.nav_pics:
                showImagesFrament();
                break;
            case R.id.nav_videos:
                showVideosFrament();
                break;
            case R.id.nav_favorites:
                showFavoriteFrament();
                break;
            case R.id.nav_tools:
                showToolsFrament();
                break;
            case R.id.nav_setting:
//                SettingActivity.start(this);
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.nav_about_app:
                AboutAppActivity.start(this);
                break;

        }
        return true;
    }

    /**
     * 跳转到
     *
     * @param activity
     */
    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, HomeActivity.class));
    }

    /*************防止误退出*************/
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Snackbar.make(mToolbar, R.string.exit_prompt, Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
