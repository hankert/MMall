package com.diabin.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.diabin.latte.net.RestClient;
import com.diabin.latte.net.callback.IError;
import com.diabin.latte.net.callback.IFailure;
import com.diabin.latte.net.callback.ISuccess;
import com.diabin.latte.util.LatteLogger;
import com.diabin.latte.util.Logger;

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


    private ISignListener mISignListener = null;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mISignListener = (ISignListener) activity;

        }
    }

    /**
     * 登录
     */
    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){

      if (checkForm()){
          RestClient.builder()
//                    .url("http://news.baidu.com/")
                  .loader(getContext())
                  .url("http://10.0.2.2:8080/webTes/TestServlet")
                  .params("email", mEmail.getText().toString())
                  .params("password", mPassword.getText().toString())
                  .success(new ISuccess() {
                      @Override
                      public void onSuccess(String response) {
                          Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                          Log.i("test", response);
                          Logger.d("test1", response);
//                            LatteLogger.i("test2", response);这个框架不能用
                          SignHandler.onSignIn(response, mISignListener);
                      }
                  })
                  .error(new IError() {
                      @Override
                      public void onError(int code, String msg) {
                          LatteLogger.i("test", code+msg);
                      }
                  })
                  .failure(new IFailure() {
                      @Override
                      public void onFailure() {
                          LatteLogger.i("test", "失败");
                      }
                  })
                  .build()
                  .get();

          Toast.makeText(getContext(), "验证通过", Toast.LENGTH_LONG).show();

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
