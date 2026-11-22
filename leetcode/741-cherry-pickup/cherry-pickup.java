class Solution {
    private int cherryPickup(int row1, int col1, int col2, int[][] grid, int[][][] dp){
        int row2 = row1 + col1 - col2;
        if(row1 == grid.length || row2 == grid.length || col1 == grid[0].length || col2 == grid[0].length || grid[row1][col1] == -1 || grid[row2][col2] == -1) return Integer.MIN_VALUE / 2;
        if(row1 == grid.length - 1 && col1 == grid[0].length - 1) return grid[row1][col1];
        if (dp[row1][col1][col2] != -1)return dp[row1][col1][col2];

        int res = 0;
        if(row1 == row2 && col1 == col2){
            res = grid[row1][col1];
        }
        else{
            res = grid[row1][col1] + grid[row2][col2];
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(max,cherryPickup(row1 + 1, col1, col2, grid, dp));
        max = Math.max(max,cherryPickup(row1 + 1, col1, col2 + 1, grid, dp));
        max = Math.max(max,cherryPickup(row1, col1 + 1, col2, grid, dp));
        max = Math.max(max,cherryPickup(row1, col1 + 1, col2 + 1, grid, dp));
        dp[row1][col1][col2] = res + max;

        return res + max;
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int[][] i : dp){
            for(int[] j : i){
                Arrays.fill(j, -1);
            }
        }
        int res = cherryPickup(0, 0, 0, grid, dp);
        
        return res > 0 ? res : 0;
    }
}