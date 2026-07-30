class Solution {
    public int pivotIndex(int[] nums) {
        int [] prefix = new int [nums.length];
        int [] postfix = new int [nums.length];
        int presum = 0;
        int postsum = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            presum += nums[i];
            prefix[i] = presum;
            postsum += nums[lastIndex - i];
            postfix[lastIndex - i] = postsum;
        }

        for (int i = 0; i < nums.length; i++){
            if (postfix[i] == prefix[i]) return i;
        }

        return -1;
    }
}