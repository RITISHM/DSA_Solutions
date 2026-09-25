/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/geek-jump/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int [n];
        dp[0] = 0;
        
        for (int i = 1; i < n; i++){
            dp[i] = dp[i-1] + Math.abs(height[i] - height[i-1]);
            if(i== 1) continue;
            dp[i] = Math.min(dp[i-2] + Math.abs(height[i] - height[i-2]), dp[i]);
        }
        
        return dp[n-1];
    }
}
