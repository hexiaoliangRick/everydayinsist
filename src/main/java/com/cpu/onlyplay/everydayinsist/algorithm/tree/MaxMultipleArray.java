package com.cpu.onlyplay.everydayinsist.algorithm.tree;

/**
 * @program: everydayinsist
 * @description: 最大乘积数组
 * @author: cpuRick
 * @create: 2022-08-22 21:27
 **/
public class MaxMultipleArray {


    public static void main(String[] args) {
        int max = maxProduct(new int[]{-3, 0, 1, -2});
        System.out.println(max);
    }


    public static int maxProduct(int[] nums) {

        int max = nums[0];
        if (nums.length == 1) {
            return max;
        }
        for (int index = 0; index < nums.length; index++) {
            int current = nums[index];
            if (current > max) {
                max = current;
            }
            for (int second = index + 1; second < nums.length; second++) {
                current = current * nums[second];
                if (current > max) {
                    max = current;
                }
            }

        }
        return max;
    }


}
