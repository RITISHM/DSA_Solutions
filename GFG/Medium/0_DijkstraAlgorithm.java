/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    
   
    
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adjList = new ArrayList<>();
        
        for (int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }
        
        
        ArrayList <Integer> distance = new ArrayList<>();
        PriorityQueue <Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        
        for (int i = 0; i < V ; i++) distance.add(Integer.MAX_VALUE);
        
        distance.set(src, 0);
        pq.add(new Pair(src, 0));
        
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            if (curr.weight > distance.get(curr.node)) {
                continue;
            }
            
            for (Pair next : adjList.get(curr.node)){
                int newWeight = next.weight + curr.weight;
                
                if (distance.get(next.node) > (newWeight)){
                    distance.set(next.node, newWeight);
                    pq.add(new Pair(next.node, newWeight));
                }
            }
        }
        return distance;
        
    }
}
