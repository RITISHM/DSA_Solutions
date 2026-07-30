class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++){
            char c = s.charAt(i);
            if(c == 'a'  || c == 'e' || c == 'i' || c == 'o' || c == 'u') count ++;

        }
        maxCount = count;

        for (int i = k; i < s.length(); i++){
            char c = s.charAt(i - k );
            if(c == 'a'  || c == 'e' || c == 'i' || c == 'o' || c == 'u') count --;
            c = s.charAt(i);
            if(c == 'a'  || c == 'e' || c == 'i' || c == 'o' || c == 'u') count ++;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}