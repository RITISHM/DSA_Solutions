class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder finalString = new StringBuilder();
        int p1 = 0;
        int  p2 =0;
        int len1 = word1.length();
        int len2 = word2.length();

        while (p1 < len1 && p2 < len2){
            finalString.append(word1.charAt(p1++));
            finalString.append(word2.charAt(p2++));
        }

        while (p1 < len1){
            finalString.append(word1.charAt(p1++));
        }

        while (p2 < len2){
            finalString.append(word2.charAt(p2++));
        }

        return finalString.toString();
    }
}