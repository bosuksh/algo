package org.example.leetcode;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums.length == 0)
            return;
        k %= nums.length;
        int[] tempNums = new int[nums.length];

        for(int i = 0;i < nums.length; i++) {
            tempNums[(i+k)%nums.length] = nums[i];
        }

        for(int i = 0;i < nums.length; i++) {
            nums[i] = tempNums[i];
        }

    }
}
