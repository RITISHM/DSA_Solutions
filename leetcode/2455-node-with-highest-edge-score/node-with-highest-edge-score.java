class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] temp = new long[n];
        int max = 0;
        for (int i = 0; i < n; i++){
            temp[edges[i]] += i;
            if (temp[max] == temp[edges[i]]){
                max = max > edges[i] ? edges[i] : max;
            }
            if (temp[max] < temp[edges[i]]){
                max = edges[i];
            }
        }
        return max;
    }
}