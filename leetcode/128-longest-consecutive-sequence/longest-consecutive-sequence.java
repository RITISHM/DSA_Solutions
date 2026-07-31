class Solution {
    public int longestConsecutive(int[] nums) {

        Set <Integer> elements = new HashSet<>();
        int maxLength = 0; 

        for (int i : nums){
            elements.add(i);
        }

        for (int i : nums){

            if (!elements.contains(i)) continue;

            int element = i;
            int length = 0;

            while(elements.contains( element )){
                length ++;
                elements.remove(element);
                element++;
            }
            element = i -1;
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