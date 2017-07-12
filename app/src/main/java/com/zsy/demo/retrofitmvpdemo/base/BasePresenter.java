package com.zsy.demo.retrofitmvpdemo.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 作者：zhengsiyu on 2017/07/12 16:27
 * 最后一次修改日期: on 2017/07/12 16:27
 * 邮箱：342861373@qq.com
 */

public class BasePresenter<V>
{
    protected Reference<V> mViewRef;
    protected V mView;

    public void attachView(V view)
    {
        mViewRef = new WeakReference<V>(view);
        mView = mViewRef.get();
    }

    public V getView()
    {
        if (mViewRef == null)
        {
            return null;
        }
        return mViewRef.get();
    }

    public boolean isViewAttached()
    {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView()
    {
        if (mViewRef != null)
        {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
