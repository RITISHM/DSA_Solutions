class Solution {

   

    public String smallestPalindrome(String s) {
        int len = s.length();
        if (len == 1 || len == 3) return s;

   
        StringBuilder sb = new StringBuilder();

        int [] chars = new int[26];
        char [] res = new char[len];

        int left = 0;
        int right = len -1;
        int curr = 0;

        for (char c : s.toCharArray()){
            chars[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 0) continue;


            if (chars[i] % 2 != 0){
                res[len/2] = (char)('a' + i);
            }

            for (int j = 0; j < chars[i] / 2; j++){
                res[left++] = (char) ('a' + i);
                res[right--] =  (char) ('a' + i);
            }
           
        }
        return new String(res);
    }
}