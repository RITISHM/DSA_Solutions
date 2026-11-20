class Solution {
    private int minPathSum(int row, int col,int[][]grid, int[][] dp){
        if (row == dp.length || col == dp[0].length) return Integer.MAX_VALUE;
        if (dp[row][col] != -1) return dp[row][col];

        int right = minPathSum(row, col + 1, grid, dp);
        int down =minPathSum(row + 1, col, grid, dp);

        dp[row][col] = Math.min(right, down)+ grid[row][col];
        return dp[row][col];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] i: dp){
            Arrays.fill(i, -1);
        }
        dp[m-1][n-1] = grid[m-1][n-1];

        return minPathSum(0, 0,grid, dp);
    }
}