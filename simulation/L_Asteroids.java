package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Asteroids {
    public static void main(String[] args) {
        int[] ans1 = asteroidCollision(new int[]{5,10,-5});
        for(int ans: ans1){
            System.out.print(ans+" ");
        }
        System.out.println();
        int[] ans2 = asteroidCollision(new int[]{8,-8});
        for(int ans: ans2){
            System.out.print(ans+" ");
        }
        System.out.println();
        int[] ans3 = asteroidCollision(new int[]{10,2,-5});
        for(int ans: ans3){
            System.out.print(ans+" ");
        }
        System.out.println();

        int[] ans4 = asteroidCollision(new int[]{-2,-1,1,2});
        for(int ans: ans4){
            System.out.print(ans+" ");
        }
        System.out.println();
    }
    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> asteroidsList = new ArrayList<>();
        for (int asteroid : asteroids) {
            asteroidsList.add(asteroid);
        }
        int idx = 0;
        while (idx < asteroidsList.size() - 1) {
            int cur = asteroidsList.get(idx);
            int next = asteroidsList.get(idx + 1);
            if (cur > 0) {
                if (next < 0) { //collision
                    if (cur + next > 0) {
                        asteroidsList.remove(idx+1);
                    } else if (cur + next == 0) {
                        asteroidsList.remove(idx+1);
                        asteroidsList.remove(idx);

                    } else {
                        asteroidsList.remove(idx);
                        if(idx > 0)
                            idx--;
                    }
                    continue;
                }
            }
            idx++;
        }
        int[] answer = new int[asteroidsList.size()];
        for(int i = 0; i< asteroidsList.size(); i++){
            answer[i] = asteroidsList.get(i);
        }
        return answer;
    }
}
