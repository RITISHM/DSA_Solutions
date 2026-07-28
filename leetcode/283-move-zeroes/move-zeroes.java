class Solution {

    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public void moveZeroes(int[] nums) {
        
        int i = 0;
        int z = 0;

        while( i < nums.length){
            if ( nums[i] ==0 ) i++;

            else {
                swap(nums, i, z);
                i++; z++;
            }
        }
    }


}