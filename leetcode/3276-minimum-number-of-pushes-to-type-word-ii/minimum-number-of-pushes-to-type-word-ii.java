class Solution {
    public int minimumPushes(String word) {
        if (word.length() == 0) return 0;

        int [] freq = new int [26];

        for (char c : word.toCharArray()){
            int index = (int) (c - 'a');
            freq[index]++;
        }

        Arrays.sort(freq);
        int pushes = 0;
        int num = 0;
        for(int i = 25; i >= 0; i--){
            int push = (num / 8) + 1;
            pushes += freq[i] * push;
            num++;
        }

        return pushes;
    }
}