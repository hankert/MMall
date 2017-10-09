package com.diabin.festec.example.generators;

import com.diabin.latte.annotations.AppRegisterGenerator;
import com.diabin.latte.wechat.templates.AppRegisterTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */
@AppRegisterGenerator(
        packageName = "com.diabin.festec.example",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
