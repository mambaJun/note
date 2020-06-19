package com.jun.demo.se;


import java.util.*;

/**
 * @author Jun
 * @date 2020/1/8 下午11:05
 */
public class Array {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{i,map.get(target - nums[i])};
            }
        }
        return new int[2];
    }

}
