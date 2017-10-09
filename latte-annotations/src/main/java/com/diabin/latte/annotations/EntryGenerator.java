package com.diabin.latte.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface EntryGenerator {

    String packageName();
    Class<?> entryTemplete();


}
