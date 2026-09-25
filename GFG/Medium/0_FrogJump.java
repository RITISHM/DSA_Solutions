/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/geek-jump/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        if (n == 1) return 0;
        int[] dp = new int [n];
        int prev1 = Math.abs(height[0] - height[1]) ;
        int prev2 = 0;
        for (int i = 2; i < n; i++){
            int curr = Math.min(prev1 + Math.abs(height[i] - height[i-1]),
                                prev2 + Math.abs(height[i] - height[i-2]));
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
