package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class KdiffPairs {

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println(findPairs(nums,k));
        int[] nums1 = {1,2,3,4,5};
        int k1 = 1;
        System.out.println(findPairs(nums1,k1));
        int[] nums2 = {1,3,1,5,4};
        int k2 = 0;
        System.out.println(findPairs(nums2,k2));
        int[] nums3 = {1,2,4,4,3,3,0,9,2,3};
        int k3 = 3;
        System.out.println(findPairs(nums3,k3));
        int[] nums4 = {-1,-2,-3};
        int k4 = 1;
        System.out.println(findPairs(nums4,k4));

    }

    public static int findPairs(int[] nums, int k) {

        if(k == 0) {
            Arrays.sort(nums);
            Map<Integer, Boolean> checkMap = new HashMap<>();
            int answer = 0;
            for(int i = 0; i < nums.length-1; i++) {
                if((nums[i] == nums[i+1]) && !checkMap.containsKey(nums[i])) {
                    answer++;
                    checkMap.put(nums[i],true);
                }
            }
            return answer;
        }
        List<Integer> numList = new ArrayList<>();
        for(int num: nums) {
            numList.add(num);
        }
        Set<Integer> targetSet = new HashSet<Integer>(numList);

        numList = targetSet.stream().collect(Collectors.toList());
        numList.sort(Comparator.naturalOrder());
        int answer = 0;
        for(int i = 0; i < numList.size() -1; i++) {
            for(int j = i+1; j< numList.size(); j++) {
                if(numList.get(j) - numList.get(i) == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
