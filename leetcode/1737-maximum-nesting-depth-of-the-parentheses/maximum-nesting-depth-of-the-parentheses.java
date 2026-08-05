class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int open = 0;

        for(char c : s.toCharArray()){
            if(c == '(') open ++;
            if(c == ')'){
                max = Math.max(open , max);
                open --;
            }
        }

        return max;
    }
}