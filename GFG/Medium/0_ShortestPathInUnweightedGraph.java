/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        int distance = 0;
        boolean[] visited = new boolean[V];
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for (int i =0; i < V; i++){
            adjMatrix.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjMatrix.get(u).add(v);
            adjMatrix.get(v).add(u);
        }
        
        Queue <Integer> nodes = new LinkedList<>();
        nodes.add(src);
        visited[src] = true;
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++){
                int node = nodes.poll();
                
                for(int nextNode : adjMatrix.get(node)){
                    if(nextNode == dest) return distance + 1;
                    if(!visited[nextNode]){
                        nodes.add(nextNode);
                        visited[nextNode] = true;
                    }
                }
            }
            distance ++;
        }
        
        return -1;
        
    }
}
