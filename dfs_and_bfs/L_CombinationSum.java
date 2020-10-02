package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    private List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        int[] visited = new int[candidates.length];
        dfs(0,candidates,target,visited);
        return answer;
    }

    private void dfs(int currentValue, int[] candidates, int target, int[] visited) {

        if(currentValue > target) {
            return;
        }

        if(currentValue == target) {
            List<Integer> subAnswer = new ArrayList<>();
            for(int i = 0; i < visited.length; i++) {
                for(int j = 0; j< visited[i]; j++)
                    subAnswer.add(candidates[i]);
            }
            if(!answer.contains(subAnswer))
                answer.add(subAnswer);
            return;
        }

        for(int i = 0; i < candidates.length; i++) {
            visited[i]++;
            dfs(currentValue+candidates[i],candidates,target,visited);
            visited[i]--;
        }
    }

}
