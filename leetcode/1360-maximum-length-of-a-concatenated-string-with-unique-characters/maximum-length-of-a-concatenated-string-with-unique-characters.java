class Solution {

    int getMask(String curr) {
        int mask = 0;
        for (char c : curr.toCharArray()){
            int position = c -'a';
            if ((mask & (1 << position)) != 0) return -1;

            mask = mask | (1 << position);          
        }
        return mask;
    }

    int helper(List<String> arr, int startIndex, int mask) {
        int n = arr.size();
        int size = Integer.bitCount(mask);

        for (int i = startIndex; i < n; i++) {
            int currMask = getMask(arr.get(i));
            if(currMask == -1 || (mask & currMask) !=0 ) continue;
            else {
                currMask = currMask | mask;
                size = Math.max(size, helper(arr, i + 1, currMask));
            }
        }
        return size;
    }

    public int maxLength(List<String> arr) {
        return helper(arr, 0, 0);
    }
}