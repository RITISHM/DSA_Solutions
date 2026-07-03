class Solution {
    int [][] visited ;
    void dfs(int currRow, int currCol, char [][] grid, int [][] visited){
        visited[currRow][currCol] = 1;
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
        for (int [] dir : dirs){
            int row = currRow + dir[0];
            int col = currCol + dir[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && visited[row][col] != 1 && grid[row][col] == '1'){
                dfs(row, col, grid, visited);
            }  
         }
  
    }
    public int numIslands(char[][] grid) {
        visited = new int [grid.length][grid[0].length];
        int islands=0;

        for (int row = 0; row < grid.length; row++ ){
            for (int col  = 0; col < grid[0].length; col++){
                if (grid[row][col] == '1' && visited[row][col] == 0 ){
                    islands ++;
                    dfs(row, col, grid, visited);
                }
            }
        }
        return islands;

    }
}