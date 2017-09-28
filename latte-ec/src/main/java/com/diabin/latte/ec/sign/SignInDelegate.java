package com.diabin.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/9/28.
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.et_sign_in_mail)
    TextInputEditText mEmail = null;
    @BindView(R2.id.et_sign_in_password)
    TextInputEditText mPassword = null;

    /**
     * 登录
     */
    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){

      if (checkForm()){


      }

    }

    /**
     * 点击去注册
     */
    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());

    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat(){


    }

    private boolean checkForm(){

        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();


        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else{
            mEmail.setError(null);
        }


        if (password.isEmpty() || password.length() < 6){
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        }else{
            mPassword.setError(null);
        }


        return isPass;
    }

    @Override
    public Object setLayout() {

        return R.layout.delegate_sign_in;

    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
