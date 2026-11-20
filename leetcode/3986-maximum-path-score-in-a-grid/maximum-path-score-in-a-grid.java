class Solution {

    private int maxPathScore(int row, int col, int k, int[][] grid, int[][][] dp) {
        int current = grid[row][col];
        int cost = current == 0? 0 : 1;
        if (dp[row][col][k] == -2) return -1;
        if(k - cost < 0) return -1;
        if (row == grid.length - 1 && col == grid[0].length - 1) return current;
        if (dp[row][col][k] != -1) return dp[row][col][k];

        int right = -1;
        int down = -1;
        if (row + 1 < grid.length){
            down = maxPathScore(row + 1, col, k - cost, grid, dp);
        }
        if (col + 1 < grid[0].length){
            right = maxPathScore(row, col + 1, k - cost, grid, dp);
        }
        if (right == -1 && down == -1){
            dp[row][col][k] = -2;
            return -1;
        }
        dp[row][col][k] = Math.max(right, down) + grid[row][col];
        return Math.max(right, down) + grid[row][col];
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][]dp = new int[m][n][k+1];
        for (int[][] i: dp){
            for (int[] j: i){
                Arrays.fill(j, -1);
            }
        }

        return maxPathScore(0, 0, k, grid, dp);
    }
}