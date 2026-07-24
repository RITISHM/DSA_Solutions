class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String [] words = s.split(" ");
        
        for (int i =0 , j = words.length - 1; i < j; i++, j--){
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        } 

        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < words.length; i++){
            String word = words[i];

            if (word.equals("")) continue;
            
            sb.append(word);
            if (i != words.length - 1)sb.append(" ");
        }
        return sb.toString();
    }
}