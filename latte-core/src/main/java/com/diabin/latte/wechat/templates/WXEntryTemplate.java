package com.diabin.latte.wechat.templates;

import com.diabin.latte.wechat.BaseWXEntryActivity;
import com.diabin.latte.wechat.LatteWeChat;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */

public class WXEntryTemplate extends BaseWXEntryActivity{


    @Override
    protected void onSignInSuccess(String userInfo) {

        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);


    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }
}
