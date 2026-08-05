class Solution {

    public void bfs(int row, int col, char [][] grid){
        int[][] dirs = {{0, 1}, {1,0}, {-1, 0}, {0, -1}};
        grid[row][col] = '0';

        Queue <int []> queue = new LinkedList <>();
        queue.offer(new int []{row, col});
        while(!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++){
                int [] node = queue.poll();
                int currRow = node[0];
                int currCol = node[1];

                for (int[] dir : dirs){
                    int nextRow = dir [0] + currRow;
                    int nextCol = dir [1] + currCol;
                    if (nextRow >= 0 && nextRow < grid.length && 
                        nextCol >= 0 && nextCol < grid[0].length &&
                        grid[nextRow][nextCol] == '1'){

                        grid[nextRow][nextCol] ='0';
                        queue.offer(new int []{nextRow, nextCol});

                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int numIsland = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (grid[row][col] == '1'){
                    bfs(row, col, grid);
                    numIsland++;

                }
            }
        }

        return numIsland;
    }
}