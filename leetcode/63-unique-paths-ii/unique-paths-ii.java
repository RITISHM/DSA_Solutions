class Solution {
    private int uniquePathsWithObstacles(int row, int col, int[][] dp){
        if (row >= dp.length || col >= dp[0].length) return 0;
        if (dp[row][col] == -2) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int curr = 0;
        curr += uniquePathsWithObstacles(row + 1, col, dp);
        curr += uniquePathsWithObstacles(row, col + 1, dp);

        dp[row][col] = curr;
        return curr;   
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];
        for (int[] i: dp){
            Arrays.fill(i, -1);
        }
        dp[m-1][n-1] = 1;
        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if(obstacleGrid[row][col] == 1){
                    dp[row][col] = -2;
                }
            }
        }

        return uniquePathsWithObstacles(0, 0, dp);
    }
}