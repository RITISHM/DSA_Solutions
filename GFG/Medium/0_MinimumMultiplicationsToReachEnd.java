/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        int[] dist = new int[1000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{start, 0});

        while(!q.isEmpty()){
            int[] node = q.poll();
            if(node[1] > dist[node[0]]) continue;
            if(node[0] == end) return node[1];
            for (int i : arr){
                int newSol = (node[0] * i) % 1000;
                if (dist[newSol] > node[1]+1){
                    dist[newSol] = node[1]+1;
                    q.add(new int[] {newSol, node[1]+1});
                }
            }
        }
        
        return -1;
    }
}
