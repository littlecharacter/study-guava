package com.lc.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author gujixian
 * @since 2022/9/8
 */
public class NationalListener {
    @Subscribe
    public void listen(EpidemicEvent event) {
        System.out.println("NationalListener：" + event.getMessage() + "，每天做核酸...");
    }

    @Subscribe
    public void listen(String event) {
        System.out.println("NationalListener：一个Listener可以监听多个事件(S)...");
    }
}
