class Solution {

    public void dfs(int currRow, int[][] isConnected, boolean[] visited){
        
        for (int col = 0; col < isConnected.length; col++) {
            if (!visited[col] && isConnected[currRow][col]== 1){
                    visited[col] = true;
                    dfs(col, isConnected, visited);
                } 
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        boolean[] visited = new boolean[isConnected.length];

        for (int row = 0; row < isConnected.length; row++){
            for(int col = 0; col < isConnected.length; col++){
                if (!visited[col] && isConnected[row][col] == 1){
                    dfs(col, isConnected, visited);
                    num++;
                }
            }
        }

        return num;
    }
}