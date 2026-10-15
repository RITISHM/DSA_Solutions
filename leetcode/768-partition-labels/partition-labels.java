class Solution {
    public List<Integer> partitionLabels(String s) {
        int [] freq = new int[26];

        for(char c : s.toCharArray()){
            int pos = c - 'a';
            freq[pos]++;
        }

        List <Integer> res =new LinkedList<>();

        int curr = 0;
        int currSize = 0;
        for (int c : s.toCharArray()){
            int pos = c - 'a';
            currSize++;
            curr = curr | (1<<pos);
            freq[pos]--;
            if (freq[pos] == 0){
                curr = curr ^ (1<<pos);
            }
            if (curr == 0){
                res.add(currSize);
                currSize = 0;
            }
        }
        return res;
    }
}