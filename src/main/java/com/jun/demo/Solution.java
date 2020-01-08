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
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.printf(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        final int target = 0;
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int[] newNums = new int[nums.length];
        newNums[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != newNums[index]) {
                newNums[++index] = nums[i];
            }
        }
        for (int i = 0; i < index - 1; i++) {

        }
        return result;
    }

    private static void listNums(int[] nums) {
        for (int num : nums) {
            System.out.printf(num + " ");
        }
        System.out.println();
    }
}
