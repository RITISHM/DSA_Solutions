class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int[][] dirs = {{1,0}, {0,1}, {1,1}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}, {1, -1}};
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dist = new int [rows][cols];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue <int[]> nodes = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        nodes.add(new int[] {0, 0, 1});
        dist[0][0] = 1;



        while(!nodes.isEmpty()){
            int[] node = nodes.poll();
            int parentDist = node[2];
            if (dist[node[0]][node[1]] < parentDist) continue;
            if(node[0] == rows-1 && node[1] == cols-1) return parentDist;

            for (int[] dir : dirs){
                int nextRow = node[0] + dir[0];
                int nextCol = node[1] + dir[1];
                int childDist = parentDist + 1;
                if (nextRow >= 0 && nextRow < rows && 
                nextCol >= 0 && nextCol < cols && 
                grid[nextRow][ nextCol] == 0){
                    
                    if(dist[nextRow][ nextCol] > childDist){
                        dist[nextRow][nextCol] = childDist ;
                        nodes.add(new int[] {nextRow, nextCol, childDist});
                    }

                }
            }
     
        }
        return -1;
    }
}