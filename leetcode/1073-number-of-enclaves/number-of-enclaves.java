class Solution {
    public void bfs(Queue <int []> nodes,int[][] grid){
        int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
       
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                int[] node = nodes.poll();
                int currRow = node[0];
                int currCol = node[1];
                for(int[] dir : dirs){
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];
                    if (nextRow >= 0 && nextRow < grid.length &&
                        nextCol >= 0 && nextCol < grid[0].length &&
                        grid[nextRow][nextCol] != 0){
                            grid[nextRow][nextCol] = 0;
                            nodes.offer(new int[] {nextRow, nextCol});
                    }
                }
            }
        } 

    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue <int []> nodes = new LinkedList<>();
        int count = 0;

        
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    if(row == 0 || row == (rows - 1) || col == 0 || col == (cols - 1)){
                        grid[row][col] = 0;
                        nodes.offer(new int []{row, col});
                    }
                }
            }
        }
        bfs(nodes, grid);

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1)count++;
            }
        }

        return count;
    }
}