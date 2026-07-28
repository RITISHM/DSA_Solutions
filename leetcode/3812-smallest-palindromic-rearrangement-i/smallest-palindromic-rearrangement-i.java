class Solution {

    void mergeSort(char [] chars, int low, int high){
        if (low >= high) return ;
        
        int mid = (( high - low ) / 2) + low;
        
        mergeSort(chars, low, mid);
        mergeSort(chars, mid+1, high);

        merge(chars, low, mid, high);
    }

    void merge(char [] chars, int low, int mid, int high){

        int lp = low;
        int rp = mid+1;
        char [] temp = new char[ high - low + 1];
        int tp = 0;

        while( lp <= mid && rp <= high) {

            if (chars[lp] <= chars[rp]) {
                temp[ tp++ ] = chars[lp++];
            }

            else {
                temp[ tp++ ] = chars[rp++];
            }
        }

        while( lp <= mid ){
            temp[ tp++ ] = chars[lp++];
        }

        while( rp <= high ){
            temp[ tp++ ] = chars[rp++];
        }

        tp = 0;

        while (tp < temp.length){
            chars[low++] = temp[tp++];
        }


    }

    public String smallestPalindrome(String s) {
        int len = s.length();
        if (len == 1 || len == 3) return s;

        int low = 0;
        int high = len - 1;
        int mid = (len / 2) - 1;

        char [] chars = s.toCharArray();
        mergeSort( chars, low, mid);
        System.out.println(new String(chars));

        for (int i = 0; i < len / 2; i++){
            chars[len - 1 - i] = chars[i];
        }

        return new String(chars);

    }
}