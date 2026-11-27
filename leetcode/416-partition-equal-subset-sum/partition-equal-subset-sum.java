class Solution {
    private boolean canPartition(int index, int target, int[] nums, int[][] dp){
        if (target == 0) return true;
        if(index == 0) return (target == nums[index]);
        if(dp[index][target] != -1) return (dp[index][target] == 1)? true: false;

        boolean notTake = canPartition(index -1, target, nums, dp);
        boolean take = false;
        if(target >= nums[index]){
            take = canPartition(index - 1, target - nums[index], nums, dp);
        }

        dp[index][target] = (take || notTake)? 1 : 0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[][] dp = new int[n][20001];
        for(int[] i: dp) Arrays.fill(i, -1);

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 !=0) return false;
        sum /= 2;

        return canPartition(n-1, sum, nums, dp);
    }
}