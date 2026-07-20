class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        int [][] dirs = {{1,0},
                         {0,1},
                         {-1,0},
                         {0,-1}};

        boolean [][] visited = new boolean [rows][cols];
        Queue <int []> levels = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
               
                if (isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    levels.offer(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!levels.isEmpty()){
            int size = levels.size();

            for (int i = 0; i < size; i++){
                int [] currNode = levels.poll();
                int cr = currNode[0];
                int cc = currNode[1];

                for (int [] dir :dirs ){
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        !visited[nr][nc]){
                            levels.offer(new int[] {nr,nc});
                            isWater[nr][nc] = isWater[cr][cc] + 1;
                            visited[nr][nc] =true;
                        }
                }

            }

        }
        return isWater;

    }
}