class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 31; i++){
            if ( ((a % 2) | (b % 2)) != (c % 2) ){
                if ( ((a % 2) & (b % 2)) == 1) count ++;
                count ++;
            }
            c >>= 1;
            a >>= 1;
            b >>= 1;
        }
        return count;
    }
}