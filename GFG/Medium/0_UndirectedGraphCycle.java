/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public List[] creatAdj( int v, int[][] edges){
        List <Integer> [] mat = new List [v];
        for (int i=0; i<v; i++)mat[i]= new ArrayList<>();
        
        for (int [] edge : edges){
            int i = edge[0];
            int j = edge[1];
            mat[i].add(j);
            mat[j].add(i);
        }
        return mat;
    }
    
    boolean checkCycle(List <Integer>[] adjMat , int src, boolean [] visited){
        Queue <Pair> q = new LinkedList<>();
        q.offer(new Pair(src , -1));
        visited[src]= true;
        while(!q.isEmpty()){
            int size= q.size();
            for (int i=0; i< size; i++){
                Pair pair = q.poll();
                
                for (int j : adjMat[pair.a]){
                    if (j == pair.b) continue;
                    if (visited[j]) return true;
                    q.offer(new Pair(j, pair.a));
                    visited[j] = true;
                }
            }
        }
        return false;
        
    }
    
    public boolean isCycle(int V, int[][] edges) {
        
        List [] adjMat = creatAdj(V , edges);
        boolean [] visited = new boolean [V];
        
        for(int i= 0; i< V; i++){
            if (visited[i] || adjMat[i] == null)continue;
            if (checkCycle(adjMat, i, visited)) return true;
        }
        
        return false;
        
    }
}
