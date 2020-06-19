package com.jun.demo;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class Solution {

    public static void main(String[] args) {
        int[][] a1 = new int[2][2];
        int[][] a2 = new int[2][2];

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                a1[i][j] = i * j;
                a2[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a1));
        System.out.println(Arrays.deepToString(a2));
        System.out.println(Arrays.deepEquals(a1, a2));
        a2[1][1] = 10;
        Arrays.sort
        System.out.println(Arrays.deepEquals(a1, a2));
    }

}
