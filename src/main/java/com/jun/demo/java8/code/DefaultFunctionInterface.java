package com.jun.demo.java8.code;

import org.junit.jupiter.api.Test;

/**
 * @author Jun
 * @date: 19-10-22 下午3:49
 */
public interface DefaultFunctionInterface {
    default String getName() {
        return "我是默认方法";
    }

    public static String show() {
        return "我是静态方法";
    }
}

class TestInterface {
    public static void main(String[] args) {
        System.out.println(DefaultFunctionInterface.show());
    }
}
