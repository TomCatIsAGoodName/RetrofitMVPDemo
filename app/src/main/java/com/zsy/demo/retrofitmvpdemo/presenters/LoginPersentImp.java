package com.zsy.demo.retrofitmvpdemo.presenters;

import com.zsy.demo.retrofitmvpdemo.avtivity.LoginActivity;
import com.zsy.demo.retrofitmvpdemo.avtivity.LoginActivityView;
import com.zsy.demo.retrofitmvpdemo.base.BasePresenter;
import com.zsy.demo.retrofitmvpdemo.entity.LoginBean;
import com.zsy.demo.retrofitmvpdemo.service.ApiServices;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：zhengsiyu on 2017/07/12 16:31
 * 最后一次修改日期: on 2017/07/12 16:31
 * 邮箱：342861373@qq.com
 */

public class LoginPersentImp extends BasePresenter<LoginActivity> implements LoginPresent {
    @Override
    public void login(String account, String password) {
        final LoginActivityView loginActivity = getView();
        String url = "http://192.168.0.57:8000/";
        Map<String, String> map = new HashMap<>();
        map.put("account", account);
        map.put("password", password);
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(url)//注意此处,设置服务器的地址
                .addConverterFactory(GsonConverterFactory.create())//用于Json数据的转换,非必须
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//用于返回Rxjava调用,非必须
                .build();
        ApiServices service = retrofit.create(ApiServices.class);
        service.LoginApi(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loginActivity.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (0 ==loginBean.getCode() && "success".equals(loginBean.getResult())){
                            loginActivity.onSuccess();
                        }else {
                            String error = "账号或密码错误";
                            loginActivity.onFail(error);
                        }
                    }
                });
    }
}
