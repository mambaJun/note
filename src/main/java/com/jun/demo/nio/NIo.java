package com.jun.demo.nio;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

/**
 * @author Jun
 * @date: 19-10-20 上午11:45
 */
public class NIo {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("--------------allocate()------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("--------------put()------------------");
        byteBuffer.put("abcdefg".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
}
