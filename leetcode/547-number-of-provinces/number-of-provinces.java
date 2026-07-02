class Solution {
    int [] visited ;

    void transversal(int node, int [][] graph, int n){

        for (int i = 0; i < n; i++){
            if (graph[node][i] == 1 && visited[i] != 1){
                visited[i]=1;
                transversal(i, graph, n);
            }
        }
        
    }

    public int findCircleNum(int[][] isConnected) {

        int provincesCount = 0;
        int nodeCount = isConnected.length;
        visited = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++){
            if (visited[i] == 1) continue;
            transversal(i, isConnected, nodeCount);
            provincesCount++;
        }

        return provincesCount;
    }
}