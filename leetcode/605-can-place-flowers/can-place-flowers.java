class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last = 0;
        for (int i = 0; i < flowerbed.length && n > 0; i++){

            if( flowerbed[i] == 0){
                if ((i-1 == -1 || flowerbed[i-1] == 0) && (i + 1 == flowerbed.length || flowerbed[i+1] == 0)){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n == 0;
    }
}