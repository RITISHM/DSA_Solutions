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
            
            if (count == 1) {
                chars[j++] = c;
                continue;
            }

            chars[j++] = c;
            String Scount = String.valueOf(count);

            for (char s : Scount.toCharArray()){
                chars[j++] = s;
            }
        }
        return j;
    }
}