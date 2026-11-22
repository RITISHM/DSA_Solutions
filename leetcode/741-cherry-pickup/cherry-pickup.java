
class Solution {

    private int solve(int r1, int c1, int c2,int[][] grid, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        int r2 = r1 + c1 - c2;

        // Invalid state
        if (r1 >= m || r2 >= m || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE / 2;
        }

        // Destination reached
        if (r1 == m - 1 && c1 == n - 1)
            return grid[r1][c1];

        if (dp[r1][c1][c2] != -1)
            return dp[r1][c1][c2];

        // Collect cherries
        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2)
            cherries += grid[r2][c2];

        // Four possible movements
        int next = Math.max(
            Math.max(solve(r1 + 1, c1, c2, grid, dp),
                solve(r1 + 1, c1, c2 + 1, grid, dp)
            ),
            Math.max(
                solve(r1, c1 + 1, c2, grid, dp),
                solve(r1, c1 + 1, c2 + 1, grid, dp)
            )
        );

        return dp[r1][c1][c2] = cherries + next;
    }

    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        return Math.max(0, solve(0, 0, 0, grid, dp));
    }
}
