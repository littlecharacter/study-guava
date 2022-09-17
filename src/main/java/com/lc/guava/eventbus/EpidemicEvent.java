package com.lc.guava.eventbus;

/**
 * @author gujixian
 * @since 2022/9/8
 */
public class EpidemicEvent {
    private String message;

    public EpidemicEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
