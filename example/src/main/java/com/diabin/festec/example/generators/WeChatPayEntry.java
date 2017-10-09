package com.diabin.festec.example.generators;

import com.diabin.latte.annotations.PayEntryGenerator;
import com.diabin.latte.wechat.templates.WXPayEntryTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */
@PayEntryGenerator(
        packageName = "com.diabin.festec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {

}
