/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        int[] ans = new int[1000];
        Arrays.fill(ans, Integer.MAX_VALUE);
        Queue <int[]> q = new LinkedList<>();
        
        q.add(new int[] {start,0});
        ans[start] = 0;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int num = curr[0];
            int mult = curr[1];
            if (ans[num] < mult) continue;
            if (num == end) return ans[num];
            for (int i : arr){
                int nextNum = (num * i) %1000;
                int nextMult = mult + 1;
                if(ans[nextNum] > nextMult){
                    ans[nextNum] = nextMult;
                    q.add(new int[] {nextNum, nextMult});
                }
            }
        }
        
        return -1;
    }
}
