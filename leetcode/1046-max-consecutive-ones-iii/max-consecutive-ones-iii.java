class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int right = 0;
        int zeroCount = 0;
        int maxWindow  = 0;


        while(right < nums.length){
            if (nums[right] == 0) zeroCount++;

            if (zeroCount > k){

                while (zeroCount > k){
                    if ( nums[left] == 0) zeroCount --;
                    left ++;
                }
            }
                maxWindow = Math.max(maxWindow, right - left + 1 );
            
                

            right++;

        }

        return maxWindow;
    }


}