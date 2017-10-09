package com.diabin.festec.example.generators;

import com.diabin.latte.annotations.EntryGenerator;
import com.diabin.latte.wechat.templates.WXEntryTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/10/9.
 */
@EntryGenerator(
        packageName = "com.diabin.festec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {



}
