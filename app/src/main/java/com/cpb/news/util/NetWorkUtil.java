package com.cpb.news.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.cpb.news.App;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述: 网络工具类
 */

public class NetWorkUtil {

    private NetWorkUtil() {

    }

    /**
     * 检查当前网络是否可用
     * @return
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm != null) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }

        return false;
    }



}
