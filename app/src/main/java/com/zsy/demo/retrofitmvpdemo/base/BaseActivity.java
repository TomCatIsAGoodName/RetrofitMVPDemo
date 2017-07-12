package com.zsy.demo.retrofitmvpdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：zhengsiyu on 2017/07/12 16:27
 * 最后一次修改日期: on 2017/07/12 16:27
 * 邮箱：342861373@qq.com
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity
{
    protected T mPresenter;

    protected void onCreate(Bundle arg)
    {
        super.onCreate(arg);
        mPresenter=createPresenter();
        mPresenter.attachView((V) this);
    }


    protected void onDestroy()
    {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract void initViews();
    protected abstract void setListener();
    protected abstract T createPresenter();
}
