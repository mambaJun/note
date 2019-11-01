package com.jun.demo.high_concurrency.code.singleton;

/**
 * @author Jun
 * @date: 19-10-30 下午3:44
 */
public class SingletonDemo2 {

    public static void main(String[] args) {
        System.out.println(Singleton.INSTANCE.getInstance());
    }

    private enum Singleton {
        INSTANCE;

        private SingletonDemo2 singleton;

        Singleton() {
            singleton = new SingletonDemo2();
        }

        public SingletonDemo2 getInstance() {
            return singleton;
        }
    }
}
