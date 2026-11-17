class Solution {
    private int rob(int[] nums, int i, int[] dp, int start){
        if (i < start) return 0;
        if (i == start) return nums[start];
        if (dp[i] != -1)return dp[i];
        
        int prev1 = rob(nums, i - 1, dp, start);
        int prev2 = nums[i] + rob(nums, i - 2, dp, start);
        dp[i] = Math.max(prev1, prev2);
        return dp[i];
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int part1 = rob(nums, nums.length - 1, dp, 1);

        Arrays.fill(dp, -1);
        int part2 = rob(nums, nums.length - 2, dp, 0);

        return Math.max(part1, part2);
    }
}