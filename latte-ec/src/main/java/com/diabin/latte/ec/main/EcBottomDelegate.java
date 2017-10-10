package com.diabin.latte.ec.main;

import android.graphics.Color;

import com.diabin.latte.delegates.button.BaseBottomDelegate;
import com.diabin.latte.delegates.button.BottomItemDelegate;
import com.diabin.latte.delegates.button.BottomTabBean;
import com.diabin.latte.delegates.button.ItemBuilder;
import com.diabin.latte.ec.main.index.IndexDelegate;
import com.diabin.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/10.
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();

        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());


        return builder.addItems(items).build();
    }
}
