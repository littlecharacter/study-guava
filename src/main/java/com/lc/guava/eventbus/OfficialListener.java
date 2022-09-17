package com.lc.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author gujixian
 * @since 2022/9/8
 */
public class OfficialListener {
    @Subscribe
    public void listen(EpidemicEvent event) {
        System.out.println("OfficialListener：" + event.getMessage() + "，组织做核酸...");

    }

    @Subscribe
    public void listen(Integer event) {
        System.out.println("OfficialListener：一个Listener可以监听多个事件(I)...");

    }
}
