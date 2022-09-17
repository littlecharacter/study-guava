package com.lc.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * 源码分析：https://juejin.cn/post/6905319095517609997
 * 1.SubscriberRegistry#getAnnotatedMethods(java.lang.Class)使用 guava 自封装的缓存
 * 2.Executor -> 同步异步
 * 3.看清 Dispatcher 具体用的那个（EventBus构造方法）
 *
 * 生产实践：https://juejin.cn/post/6844903538183634952
 * 1.自定义 @EventBusListener 注解
 * 2.EventBusCenter 简单封装 EventBus
 * 3.自定义注解 + Spring 完成 EventBusCenter 监听者的注册
 */
public class EventBusStudy {
    public static void main(String[] args) {
        //创建EventBus对象和名称
        EventBus epidemicEventBus = new EventBus("epidemic");
        // EventBus epidemicEventBus = new AsyncEventBus("epidemic", new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024)));

        //注册所有的订阅者
        epidemicEventBus.register(new OfficialListener());
        epidemicEventBus.register(new NationalListener());

        //发布疫情爆发事件
        System.out.println("发布疫情爆发事件");
        epidemicEventBus.post(new EpidemicEvent("疫情爆发"));
        // epidemicEventBus.post(2);
        System.out.println("发布一个普通事件");
        epidemicEventBus.post("普通事件");
    }
}
