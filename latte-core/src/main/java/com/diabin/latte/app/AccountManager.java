package com.diabin.latte.app;

import com.diabin.latte.util.storage.LattePreference;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */

public class AccountManager {

    private enum SignTag{

        SIGN_TAG
    }
    //保存用户的登录状态 登录后调用
    public static void setSignState(boolean state){

        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);

    }

    //
    private static boolean isSignIn(){

        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){

        if (isSignIn()){
            checker.onSignIn();
        }else{
            checker.onNotSignIn();


        }
    }
}
