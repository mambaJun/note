package com.jun.demo.high_concurrency.code.publish;

/**
 * @author Jun
 * @date: 19-10-30 下午3:35
 */
public class Escape {
    private Integer thisCanBeEscape = 0;

    public static void main(String[] args) {
        new Escape();
    }

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            System.out.println("##########################################");
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }
}
