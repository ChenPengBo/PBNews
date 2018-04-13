package com.cpb.news.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-12
 * 描述: 新闻频道
 */

@Entity
public class NewsChannel {

    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private boolean isSelect;
    @NotNull
    private int index;

    private Boolean isFixed;//是否固定

    @Generated(hash = 369350956)
    public NewsChannel(String id, @NotNull String name, @NotNull String type,
            boolean isSelect, int index, Boolean isFixed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isSelect = isSelect;
        this.index = index;
        this.isFixed = isFixed;
    }

    @Generated(hash = 566079451)
    public NewsChannel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getIsFixed() {
        return this.isFixed;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }
}
