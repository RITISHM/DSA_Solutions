class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 )return 0;


        Set <Integer> elements = new HashSet<>();
        int maxLength = 1; 

        for (int i = 0; i < nums.length; i++){

            elements.add(nums[i]);
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