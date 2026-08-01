class Solution {
    public int getSum(int a, int b) {
        int and = (a & b) << 1;
        int xor = (a^b);

        if (and == 0) return xor ;

        return getSum(and , xor);
    }
}