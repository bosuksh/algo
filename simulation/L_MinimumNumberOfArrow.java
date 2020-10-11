package org.example.leetcode;

import java.util.*;

public class MinimumNumberOfArrow {
    public static void main(String[] args) {
        int[][] points1 = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points3 = {{1,2}};
        int[][] points4 = {{2,3},{2,3}};

        System.out.println(findMinArrowShots(points1));
        System.out.println(findMinArrowShots(points2));
        System.out.println(findMinArrowShots(points3));
        System.out.println(findMinArrowShots(points4));
    }

    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrow = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] >=  end ) {
                arrow++;
                end = point[1];
            }
        }

        return arrow;
    }
}
