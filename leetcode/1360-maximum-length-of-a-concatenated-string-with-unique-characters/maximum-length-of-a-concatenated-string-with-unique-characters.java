class Solution {

    boolean isValid(String curr){
        int [] mask = new int[26];
        for (char c : curr.toCharArray()){
            int index = c - 'a';
            if (mask[index] == 1) return false;
            mask[index] = 1;
        }
        return true;
    }

    int helper(String curr, List <String> arr , int next){
        int n  = arr.size();
        int size = curr.length();
        for (int i = next ; i < n; i ++){
            String temp = curr + arr.get(i);
            if(isValid(temp)){
                int res = helper(temp, arr, i +1);
                if (res > 0 ) size = Math.max(size, res);
            }
        }
        return size;
    }

    public int maxLength(List<String> arr) {
        return helper("", arr, 0);
    }
}