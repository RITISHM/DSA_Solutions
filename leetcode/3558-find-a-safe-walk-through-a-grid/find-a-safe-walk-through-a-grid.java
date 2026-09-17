class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        int[][] dirs ={{0,1}, {1,0}, {-1, 0}, {0, -1}} ;

        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        int srcDist = grid.get(0).get(0); 
        pq.add(new int[] {0, 0, srcDist});
        dist[0][0] = srcDist;

        while (!pq.isEmpty()){
            int[] node = pq.poll();
            int currDist = node[2];
            if(currDist > dist[node[0]][node[1]]) continue;

            for(int[] dir : dirs){
                int nextRow = node[0] + dir[0];
                int nextCol = node[1] + dir[1];
                
                if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols){
                    int nextDist = currDist + grid.get(nextRow).get(nextCol);
                    if (nextDist < dist[nextRow][nextCol]){
                        dist[nextRow][nextCol] = nextDist;
                        pq.add(new int[] {nextRow, nextCol, nextDist});
                    }
                }
            }
        }

        return dist[rows-1][cols-1] < health;       

    }
}