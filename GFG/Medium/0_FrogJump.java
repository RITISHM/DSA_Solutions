/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/geek-jump/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    int[] dp;
    
    int minHealth(int i, int[] arr){
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];
        
        int left = minHealth(i - 1, arr) + Math.abs(arr[i] - arr[i-1]);
        
        if(i == 1){
            dp[i] = left;
            return left;
        }
        
        int right = minHealth(i - 2, arr) + Math.abs(arr[i] - arr[i-2]);
        
        dp[i] = Math.min(left, right);
        return dp[i];
        
    }
    
    int minCost(int[] height) {
        int n = height.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return minHealth(n-1, height);
        
    }
}
