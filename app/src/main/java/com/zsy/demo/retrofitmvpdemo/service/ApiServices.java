package com.zsy.demo.retrofitmvpdemo.service;

import com.zsy.demo.retrofitmvpdemo.entity.LoginBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：zhengsiyu on 2017/07/12 16:29
 * 最后一次修改日期: on 2017/07/12 16:29
 * 邮箱：342861373@qq.com
 */

public interface ApiServices {

    //注册
    @POST("testjson/login/")
    Observable<LoginBean> LoginApi(@QueryMap Map<String,String> login);
}
