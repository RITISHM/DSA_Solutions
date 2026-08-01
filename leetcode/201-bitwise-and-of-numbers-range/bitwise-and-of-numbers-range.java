class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;
        while(left < right){
            shifts++;
            left >>= 1;
            right >>= 1;
        }

        left <<= shifts;
        return left;
    }
}