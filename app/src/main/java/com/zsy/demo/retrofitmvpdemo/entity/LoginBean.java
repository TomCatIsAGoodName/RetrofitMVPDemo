package com.zsy.demo.retrofitmvpdemo.entity;

/**
 * 作者：zhengsiyu on 2017/07/12 16:31
 * 最后一次修改日期: on 2017/07/12 16:31
 * 邮箱：342861373@qq.com
 */

public class LoginBean {


    /**
     * code : 0
     * data : {"justshow":"justshow"}
     * result : success
     */

    private int code;
    private DataBean data;
    private String result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class DataBean {
        /**
         * justshow : justshow
         */

        private String justshow;

        public String getJustshow() {
            return justshow;
        }

        public void setJustshow(String justshow) {
            this.justshow = justshow;
        }
    }
}
