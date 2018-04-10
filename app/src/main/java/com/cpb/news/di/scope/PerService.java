package com.cpb.news.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 作者: ChenPengBo
 * 时间: 2018-04-10
 * 描述:
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}
