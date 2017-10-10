package com.diabin.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.delegates.button.BottomItemDelegate;
import com.diabin.latte.ec.R;


/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/10.
 */

public class IndexDelegate extends BottomItemDelegate{


    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
