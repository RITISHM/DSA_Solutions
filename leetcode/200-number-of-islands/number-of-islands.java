class Solution {
        void dfs(int currRow, int currCol, char [][] grid){
        grid[currRow][currCol] = '0';
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
        for (int [] dir : dirs){
            int row = currRow + dir[0];
            int col = currCol + dir[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'){
                dfs(row, col, grid);
            }  
         }
  
    }
    public int numIslands(char[][] grid) {
        int islands=0;

        for (int row = 0; row < grid.length; row++ ){
            for (int col  = 0; col < grid[0].length; col++){
                if (grid[row][col] == '1' ){
                    islands ++;
                    dfs(row, col, grid);
                }
            }
        }
        return islands;

    }
}