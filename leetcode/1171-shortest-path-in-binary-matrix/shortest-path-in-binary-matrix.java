class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        int[][] dirs = {
            {1, 0}, {0, 1}, {1, 1}, {0, -1},
            {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}
        };

        int[][] dist = new int[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        dist[0][0] = 1;
        q.offer(new int[]{0, 0, 1});

        while (!q.isEmpty()) {

            int[] node = q.poll();

            int row = node[0];
            int col = node[1];
            int currDist = node[2];

            // Outdated entry
            if (currDist > dist[row][col]) {
                continue;
            }

            // We reached destination
            if (row == rows - 1 && col == cols - 1) {
                return currDist;
            }

            for (int[] dir : dirs) {

                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < cols &&
                    grid[nextRow][nextCol] == 0) {

                    int newDist = currDist + 1;

                    if (newDist < dist[nextRow][nextCol]) {

                        dist[nextRow][nextCol] = newDist;

                        q.offer(
                            new int[]{nextRow, nextCol, newDist}
                        );
                    }
                }
            }
        }

        return -1;
    }
}