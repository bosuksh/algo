package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals));
        int[][] intervals1 = {{1,4},{2,3}};
        System.out.println(removeCoveredIntervals(intervals1));
        int[][] intervals2 = {{0,10},{5,12}};
        System.out.println(removeCoveredIntervals(intervals2));
        int[][] intervals3 = {{3,10},{4,10},{5,11}};
        System.out.println(removeCoveredIntervals(intervals3));
        int[][] intervals4 = {{1,2},{1,4},{3,4}};
        System.out.println(removeCoveredIntervals(intervals4));
    }


    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        Map<Integer, Boolean> map = new HashMap<>();
        int intervalCount = intervals.length;
        for(int i = 0; i < intervals.length-1; i++) {
            if(map.containsKey(i))
                continue;
            for(int j= i+1; j < intervals.length; j++) {
                if((intervals[i][0] == intervals[j][0] && intervals[i][1] >= intervals[j][1]) && !map.containsKey(j)) {
                    intervalCount--;
                    map.put(i,true);
                }
                if((intervals[i][0] < intervals[j][0] && intervals[i][1] >= intervals[j][1]) && !map.containsKey(j)) {
                    intervalCount--;
                    map.put(j,true);
                }
            }
        }
        return intervalCount;
    }
}
