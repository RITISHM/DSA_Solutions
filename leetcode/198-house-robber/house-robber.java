class Solution {

    int[] dp;

    int maxAmount(int i, int [] arr){
        if (i == 0) {
            return arr[0];
        }

        if (i == 1) {
            return Math.max(arr[0], arr[1]);
        }

        if (dp[i] != -1) return dp[i];

        dp[i] = Math.max(maxAmount(i -1, arr),maxAmount(i - 2, arr) + arr[i]);
        return dp[i];

    }
    public int rob(int[] nums) {
        dp = new int [nums.length];
        Arrays.fill(dp, -1);
        return maxAmount(nums.length - 1, nums);
    }
}