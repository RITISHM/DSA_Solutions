class Solution {
    private int uniquePaths(int row, int col, int[][] dp){
        if (dp[row][col] != -1) return dp[row][col];
        int curr = 0;
        
        if (row + 1 < dp.length)
        curr += uniquePaths(row+1, col, dp);
        if (col + 1 < dp[0].length)
        curr += uniquePaths(row, col + 1, dp);

        dp[row][col] = curr;
        return dp[row][col];
        
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] i : dp){
            Arrays.fill(i, -1);
        }
        dp[m-1][n-1] = 1;

        return uniquePaths(0, 0, dp);
    }
}