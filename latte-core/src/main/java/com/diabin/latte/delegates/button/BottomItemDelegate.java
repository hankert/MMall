package com.diabin.latte.delegates.button;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.R;
import com.diabin.latte.delegates.LatteDelegate;

import static android.R.attr.keycode;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/10.
 */

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener{

    private long mExitTime = 0;
    private static final int EXIT_TIME = 2000;


    @Override
    public void onResume() {
        super.onResume();
        View rootView = getView();
        if (rootView != null){
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keycode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_DOWN){

                if ((System.currentTimeMillis() - mExitTime) > mExitTime ){
                    Toast.makeText(getContext(), "双击退出"+getString(R.string.app_name), Toast.LENGTH_LONG).show();
                    mExitTime = System.currentTimeMillis();
                }else{
                    _mActivity.finish();
                    if (mExitTime != 0){
                        mExitTime = 0;
                    }
                }
                return  true;

            }
            return false;
    }
}
