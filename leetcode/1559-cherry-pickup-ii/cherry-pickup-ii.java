class Solution {
    private int cherryPickup(int row, int col1, int col2,int[][] grid, int[][][] dp){
        if (col1 < 0 || col1 == grid[0].length || col2 < 0 || col2 == grid[0].length) return 0;

        int res = col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
        if (row == grid.length - 1){
            return res;
        }

        if (dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int max = 0;
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                int curr = cherryPickup(row + 1, col1 + i, col2 + j, grid, dp);
                max = Math.max(max, curr);
            }
        }
        res += max;

        dp[row][col1][col2] = res;
        return res;

    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int[][] i : dp){
            for (int[] j : i){
                Arrays.fill(j, -1);
            }
        }

        

        return cherryPickup(0, 0, n-1, grid, dp);
    }
}