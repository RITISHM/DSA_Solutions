class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0 ;
        for (int i = 1; i < 31; i++){
            if((start % 2) != (goal % 2)) count ++;
            goal >>= 1;
            start >>= 1;
        }
        return count;
    }
}