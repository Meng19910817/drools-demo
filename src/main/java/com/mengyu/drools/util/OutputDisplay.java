package com.mengyu.drools.util;

/**
 * @author zoumengyu
 */
public class OutputDisplay {

    public void showText(String someText) {
        long time = System.currentTimeMillis();
        System.out.println("time=" + time + "-" + someText);
    }

}
