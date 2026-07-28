class Solution {

   

    public String smallestPalindrome(String s) {
        int len = s.length();
        if (len == 1 || len == 3) return s;

   
        StringBuilder sb = new StringBuilder();

        int [] chars = new int[26];
        char middle ='a';

        for (char c : s.toCharArray()){
            chars[c - 'a']++;
        }

        for (int i = 0; i < 26; i++){

            if (chars[i] % 2 == 1) middle = (char) ('a' + i);

            for (int j = 0; j < chars[i] / 2; j++ ){
                sb.append((char) ('a' + i));
            }
        }
        
        String firstHalf = sb.toString();
        String secondHalf = sb.reverse().toString();

        
        if (len % 2 != 0 && middle != '\0') {
            return firstHalf + middle + secondHalf;
        }

        return firstHalf + secondHalf;

    }
}