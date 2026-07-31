class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set <Integer> elements = new HashSet<>();
        int maxLength = 0; 

        for (int i : nums){
            elements.add(i);
        }

        for (int i = 0; i < nums.length; i++){

            if (!elements.contains(nums[i])) continue;

            int element = nums[i];
            int length = 0;

            while(elements.contains( element )){
                length ++;
                elements.remove(element);
                element++;
            }


            element = nums[i] -1;


            while(elements.contains( element )){
                length ++;
                elements.remove(element);
                element--;
            }

            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    }
}