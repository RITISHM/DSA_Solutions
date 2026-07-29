class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right ) {
            int smallerEdge = Math.min( height[left] , height[right]);
            int currentWater = smallerEdge * (right - left);
            max = Math.max(max, currentWater);

            while( height[left] <= smallerEdge && left < right ) left++ ;

            while( height[right] <= smallerEdge && left < right ) right-- ;
        }

        return max;
    }
}