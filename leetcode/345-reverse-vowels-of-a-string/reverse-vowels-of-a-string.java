class Solution {
    boolean isVowel(char c){
        return (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u');
    }

    public String reverseVowels(String s) {
        int left =0;
        char [] arr = s.toCharArray();
        int right = s.length() - 1;

        while (left < right ){
            while (left < right && !isVowel(arr[left])) left++;
            while (left < right && !isVowel(arr[right])) right--;

            if (left < right){
                char c = arr[left];
                arr[left++] = arr[right];
                arr[right--] = c;
            }

        }
        return new String(arr);
    }
}