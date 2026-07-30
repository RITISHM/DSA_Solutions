class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxWindow = 0;

        while( right < nums.length){
            if (nums[ right ] == 0) zeroCount++;

            if (zeroCount == 2){
                
                while(zeroCount > 1){
                    if (nums[left] == 0) zeroCount-- ;
                    left++;
                } 

            }

            maxWindow = Math.max(maxWindow, right - left  + 1);

            right ++;
        }

        return maxWindow - 1;
    }
}