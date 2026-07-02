class Solution {
    int [] visited ;

    void transversal(int node, int [][] graph, int n){
        Queue <Integer> bfs=new LinkedList<>();

        bfs.offer(node);

        while(!bfs.isEmpty()){

            int currNode = bfs.poll();

            for (int i = 0; i < n; i++ ){
                if (graph[currNode][i]==1 && visited[i] != 1){

                    visited[i] = 1;
                    bfs.offer(i);

                }
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