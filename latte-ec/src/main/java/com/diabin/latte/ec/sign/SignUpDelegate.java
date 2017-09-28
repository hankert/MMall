package com.diabin.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

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

public class SignUpDelegate extends LatteDelegate{

    @BindView(R2.id.et_sign_up_name)
    TextInputEditText mName;
    @BindView(R2.id.et_sign_up_mail)
    TextInputEditText mEmail;
    @BindView(R2.id.et_sign_up_phone)
    TextInputEditText mPhone;
    @BindView(R2.id.et_sign_up_re_password)
    TextInputEditText mRePassWord;
    @BindView(R2.id.et_sign_up_password)
    TextInputEditText mPassword;

    /**
     * 点击注册
     */
    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp(){
        if (checkForm()){
//            RestClient.builder()
//                    .url("sign_up")
//                    .params("", "")
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//
//                        }
//                    })
//                    .build()
//                    .post();

            Toast.makeText(getContext(), "验证通过", Toast.LENGTH_LONG).show();
        }

    }


    private boolean checkForm(){

        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();
        final String phone = mPhone.getText().toString();
        final String repassword = mRePassWord.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()){
            mName.setError("请输入姓名");
            isPass = false;
        }else{
            mName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else{
            mEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11){
            mPhone.setError("手机号码错误");
            isPass = false;
        }else{
            mPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < 6){
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        }else{
            mPassword.setError(null);
        }

        if (repassword.isEmpty() || repassword.length()<6 || !(repassword.equals(password))){
            mRePassWord.setError("密码验证错误");
            isPass = false;
        }else{
            mRePassWord.setError(null);
        }
            return isPass;

    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
