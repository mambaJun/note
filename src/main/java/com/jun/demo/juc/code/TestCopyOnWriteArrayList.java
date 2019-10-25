package com.jun.demo.juc.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Jun
 * @date: 19-10-25 下午12:57
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new HelloThread()).start();
        }
    }
}

class HelloThread implements Runnable {

    //    private static List<String> list = new CopyOnWriteArrayList<>();
    private static List<String> list = new ArrayList<>();

    static {
        list.add("AAAAAAA");
        list.add("BBBBBBB");
        list.add("CCCCCCC");
    }

    @Override
    public void run() {
        for (String str : list) {
            System.out.println(str);
            list.add("AA");
        }
    }
}
