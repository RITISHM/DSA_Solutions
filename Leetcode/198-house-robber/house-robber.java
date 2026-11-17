class Solution {
    private int rob(int[] nums, int i, int[] dp){
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (dp[i] != -1)return dp[i];
        
        int prev1 = rob(nums, i - 1, dp);
        int prev2 = nums[i] + rob(nums, i - 2, dp);
        dp[i] = Math.max(prev1, prev2);
        return dp[i];
    }
        
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return rob(nums, nums.length - 1, dp);
    }
}