class Solution {

    public void dfs(int currRow, int[][] isConnected ){
        
        for (int col = 0; col < isConnected.length; col++) {
            if ( isConnected[currRow][col]== 1){
                    isConnected[currRow][col] = 0;
                    dfs(col, isConnected);
                } 
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        

        for (int row = 0; row < isConnected.length; row++){
            for(int col = 0; col < isConnected.length; col++){
                if (isConnected[row][col] == 1){
                    dfs(col, isConnected);
                    num++;
                }
            }
        }

        return num;
    }
}