class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int count = 0;
        int mul = 1;
        while (len > 8){
            len -= 8;
            count += (8 * mul);
            mul++;
        }

        count += (mul * len);
        return count ;

    }
}