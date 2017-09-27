package com.diabin.festec.example;

import com.diabin.latte.activities.ProxyActivity;

import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.ec.launcher.LauncherDelegate;
import com.diabin.latte.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity{


    @Override
    public LatteDelegate setRootDelegate() {
        //return new ExampleDelegate();
        //return new LauncherDelegate();
        return new LauncherScrollDelegate();
    }
}
