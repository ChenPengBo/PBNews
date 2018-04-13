package com.cpb.news.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cpb.news.dao.DaoMaster;
import com.cpb.news.dao.NewsChannelDao;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-13
 * 描述:
 */

public class DBHelper extends DaoMaster.OpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //操作数据库的更新
        // TODO: 2018/4/13 此处待深入理解
        MigrationHelper.migrate(db, NewsChannelDao.class);
    }
}
