class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] effort = new int [rows][cols];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue <int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]) );

        pq.add(new int[] {0,0,0});
        effort[0][0] = 0;

        while(!pq.isEmpty()){
            int [] node = pq.poll();
            int r = node[0];
            int c = node[1];
            int currEffort = node[2];

            if (r == rows - 1 && c == cols - 1){
                return currEffort;
            }

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols){ 
                        int nextEffort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), currEffort);

                        if (effort[nr][nc] > nextEffort){
                            effort[nr][nc] = nextEffort;
                            pq.add(new int[]{nr, nc, nextEffort});
                        }
                    }
            }
        }

        return effort[rows - 1][cols - 1];
        
    }
}