class Solution {
    public int compress(char[] chars) {
        int j = 0;
        int i = 0;
        while(i < chars.length){
            int count = 0;
            char c = chars[i];
            while (i < chars.length && chars[i] == c){
                i++;
                count ++;
            }

            chars[j++] = c;
            if (count > 1){
                for (char s : String.valueOf(count).toCharArray()){
                    chars[j++] = s;
                }
            }
        }
        
        return j;
    }
}