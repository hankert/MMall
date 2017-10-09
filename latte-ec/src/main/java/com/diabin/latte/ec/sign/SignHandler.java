package com.diabin.latte.ec.sign;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diabin.latte.app.AccountManager;
import com.diabin.latte.ec.database.DatabaseManager;
import com.diabin.latte.ec.database.UserProfile;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */

public class SignHandler {

    public static void onSignUp(String response, ISignListener signListener){

        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");

        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final String avatar = profileJson.getString("avatar");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并且登录成功了
        AccountManager.setSignState(true);

        signListener.onSignUpSuccess();
    }


    public static void onSignIn(String response, ISignListener signListener){

        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");

        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final String avatar = profileJson.getString("avatar");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并且登录成功了
        AccountManager.setSignState(true);

        signListener.onSignInSuccess();
    }


}
