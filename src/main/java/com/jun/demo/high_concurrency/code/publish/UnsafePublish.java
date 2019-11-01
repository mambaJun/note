package com.jun.demo.high_concurrency.code.publish;

import java.util.Arrays;

/**
 * punish object
 *
 * @author Jun
 * @date: 19-10-30 下午3:31
 */
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        UnsafePublish unsafePublish = new UnsafePublish();
        Arrays.toString(unsafePublish.getStates());
        unsafePublish.getStates()[0] = "d";
        Arrays.toString(unsafePublish.getStates());
        return states;
    }
}
