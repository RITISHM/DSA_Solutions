class Solution {
    Random rand = new Random();
    void swap(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int quickSelect(int L, int R, int [] nums){
        int randomIndex = L + rand.nextInt(R - L + 1);
        swap(L, randomIndex, nums);

        int pivot = L;
        int i = L+1;
        int j = R;
        while(i <= j){
            while(i <= R && nums[pivot] < nums[i]) i++;
            while(j >= (L + 1) && nums[pivot] > nums[j]) j--;

            if(i <= j) {
                swap(i, j, nums);
                i++;
                j--;
            }
        }
        swap(L , j, nums);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        int L = 0;
        int R = nums.length - 1;
        int pivot = quickSelect(L , R, nums);

        while (pivot != (k-1)){
            if(pivot > (k - 1)) R = pivot - 1;
            else L = pivot + 1;
            pivot = quickSelect(L, R, nums);                
        }

        return nums[pivot];
    }
}