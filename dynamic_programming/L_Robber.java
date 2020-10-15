package org.example.leetcode;

public class Robber {

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[][][] dp = new int[nums.length][2][2];
        for(int i = 0; i< nums.length; i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++) {
                    dp[i][j][k]=-1;
                }
            }
        }
        int a = dfs(1,nums.length,0,0,nums,dp);
        int b = dfs(1,nums.length,1,1,nums,dp);
        return Math.max(a,b);
    }
    public int dfs(int cur, int n, int previous_visit, int startRob, int[] nums ,int[][][] dp) {
        if(cur == n-1) {
            dp[cur][previous_visit][startRob] = 0;
            if(startRob == 1){
                dp[cur][previous_visit][startRob] += nums[0];
            }else if(previous_visit == 0) {
                dp[cur][previous_visit][startRob] += nums[cur];
            }
            return dp[cur][previous_visit][startRob];
        }

        if(cur >= n)
            return 0;
        if(dp[cur][previous_visit][startRob] != -1)
            return dp[cur][previous_visit][startRob];
        if(previous_visit == 1) {
            dp[cur][previous_visit][startRob] = dfs(cur+1,n,0,startRob,nums,dp);
        }else {
            int a = dfs(cur+1,n,0,startRob,nums,dp);
            int b = dfs(cur+1,n,1,startRob,nums,dp)+nums[cur];
            dp[cur][previous_visit][startRob] = Math.max(a,b);
        }
        return dp[cur][previous_visit][startRob];
    }
}
