class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;

        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int curr_sum = nums[ left ] + nums[ right ];

            if (curr_sum == k) {
                count++;
                right --;
                left++;
            }

            else if(curr_sum < k) left++;

            else right--;
        }

        return count;
    }
}