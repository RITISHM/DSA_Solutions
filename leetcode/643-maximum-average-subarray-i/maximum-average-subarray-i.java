class Solution {
    public double findMaxAverage(int[] nums, int k) {
       double maxAverage = 0;
       
       int sum = 0;
       for (int i = 0; i < k; i++){
        sum += nums[i];
       } 
       maxAverage = ((double) sum )/ k;


       for (int i = k; i < nums.length; i++ ){
        sum -= nums[i - k];
        sum += nums[i];

        double average =( (double) sum) / k;
        maxAverage = maxAverage > average ? maxAverage : average;
       }

       return maxAverage;
    }
}