class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0; 
        
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for (int row = m - 1; row >= 0; row--){
            for(int col = n - 1; col >= 0; col--){
                if (obstacleGrid[row][col] == 1) continue;
                if (row == m - 1 && col == n - 1) continue;
                int right = 0;
                int down = 0;
                
                if(row + 1 < m){
                    down = dp[row + 1][col];
                }
                if(col + 1 < n){
                    right = dp[row][col+1];
                }
                dp[row][col] = right + down;
            }
        }
        return dp[0][0];
    }
}