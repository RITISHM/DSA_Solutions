class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int prefix = 0; 
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        for (int i = 0; i < nums.length; i++){
            if ( ((double)(sum - nums[i])) / 2 == (double) prefix ) return i;
            prefix += nums[i];

        }

        return -1;
    }
}