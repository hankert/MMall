package com.diabin.latte.delegates.button;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/10.
 */

public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;



    public BottomTabBean(CharSequence ICON, CharSequence TITLE) {
        this.ICON = ICON;
        this.TITLE = TITLE;
    }

    public CharSequence getICON() {
        return ICON;
    }

    public CharSequence getTITLE() {
        return TITLE;
    }
}
