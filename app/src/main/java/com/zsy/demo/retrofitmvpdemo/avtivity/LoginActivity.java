package com.zsy.demo.retrofitmvpdemo.avtivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zsy.demo.retrofitmvpdemo.R;
import com.zsy.demo.retrofitmvpdemo.base.BaseActivity;
import com.zsy.demo.retrofitmvpdemo.presenters.LoginPersentImp;

/**
 * 作者：zhengsiyu on 2017/07/12 16:26
 * 最后一次修改日期: on 2017/07/12 16:26
 * 邮箱：342861373@qq.com
 */

public class LoginActivity extends BaseActivity<LoginActivity,LoginPersentImp> implements LoginActivityView,View.OnClickListener {

    private EditText mAccountEditText;
    private EditText mPasswordEditText;
    private Button mSubmitButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        setListener();
    }

    @Override
    protected void initViews() {
        mAccountEditText = (EditText) findViewById(R.id.account_editText);
        mPasswordEditText = (EditText) findViewById(R.id.password_editText);
        mSubmitButton = (Button) findViewById(R.id.login_button);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
    }

    @Override
    protected void setListener() {
        mSubmitButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
    }

    @Override
    protected LoginPersentImp createPresenter() {
        return new LoginPersentImp();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_button:
                String account = mAccountEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();
                mPresenter.login(account,password);
                break;
            case R.id.cancel_button:
                clearEditText();
                break;
        }

    }

    @Override
    public void onSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearEditText() {
        mAccountEditText.setText("");
        mPasswordEditText.setText("");
    }
}
