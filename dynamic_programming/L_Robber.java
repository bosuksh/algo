package org.example.leetcode;

public class Robber {

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j < 1; j++){
                dp[i][j] = 0;
            }
        }
        int answer = Math.max(dfs(1,nums.length,0, nums ,dp),dfs(2,nums.length,0, nums,dp));
        int answer2 = dfs(0,nums.length,1, nums ,dp);

        return Math.max(answer,answer2);
    }

    public int dfs(int cur, int n, int startRob, int[] nums, int[][] dp) {
        if(cur == n-1) {
            if(startRob == 0){
                return nums[cur];
            }else {
                return 0;
            }
        }
        if(cur >= n)
            return 0;

        if(dp[cur][startRob] != 0)
            return dp[cur][startRob];


        dp[cur][startRob] = Math.max(dfs(cur+2,n,startRob,nums,dp),dfs(cur+3,n,startRob,nums,dp))+nums[cur];

        return dp[cur][startRob];
    }
}
