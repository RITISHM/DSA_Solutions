import java.util.Arrays;

public class Solution {
       private int get(int[][] grid, int r1, int c1, int r2, Integer[][][] dp) {
        int c2 = r1 + c1 - r2, n = grid.length;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || r1 > r2 || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        if (dp[r1][c1][r2] != null)
            return dp[r1][c1][r2];
        return dp[r1][c1][r2] = grid[r1][c1] + (r1 == r2 && c1 == c2 ? 0 : grid[r2][c2])
                + Math.max(Math.max(get(grid, r1 + 1, c1, r2 + 1, dp), get(grid, r1 + 1, c1, r2, dp)),
                        Math.max(get(grid, r1, c1 + 1, r2 + 1, dp), get(grid, r1, c1 + 1, r2, dp)));
    }

    public int cherryPickup(int[][] grid) {
        return Math.max(0, get(grid, 0, 0, 0, new Integer[grid.length][grid.length][grid.length]));

    }
}