class Solution {
    int common_mul ;
    long sum ;
    
    long buildNonZero( int n){
        if (n == 0) return 0;

        int lastDigit = n % 10;
        sum += lastDigit;

        if (lastDigit == 0) return buildNonZero(n/10);
        
        long curr_num =(long) (buildNonZero(n/10)*Math.pow(10,common_mul )) + lastDigit;
        common_mul = 1;
        return curr_num;
    }



    public long sumAndMultiply(int n) {
        sum =0;
        common_mul = 1;
        return   buildNonZero(n) * sum ;     
    }
}