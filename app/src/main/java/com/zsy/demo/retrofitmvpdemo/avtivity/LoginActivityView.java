package com.zsy.demo.retrofitmvpdemo.avtivity;

/**
 * 作者：zhengsiyu on 2017/07/12 16:27
 * 最后一次修改日期: on 2017/07/12 16:27
 * 邮箱：342861373@qq.com
 */

public interface LoginActivityView {
    void onSuccess();
    void onFail(String error);
    void clearEditText();
}
