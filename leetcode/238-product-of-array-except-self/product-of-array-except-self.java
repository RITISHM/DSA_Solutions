class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] suffixProd = new int [nums.length];
        int suffix = 1;
        int [] prefixProd = new  int [nums.length];
        int prefix = 1;

        for (int i = 0; i < nums.length; i++ ){
            suffixProd[i] = suffix;
            suffix *= nums[i];
        } 

        for (int i = nums.length-1; i >= 0; i--){
            prefixProd[i] = prefix;
            prefix *= nums[i]; 
        }

        for (int i = 0; i < nums.length; i++ ){
            nums[i] = prefixProd[i] * suffixProd[i];
        }

        return nums;
    }
}