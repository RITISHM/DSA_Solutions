class Solution {
    private int minimumTotal(int row, int col, int m, List<List<Integer>> triangle, int[][] dp){
        if (row == m - 1) return triangle.get(row).get(col);
        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int move2 = minimumTotal(row + 1, col, m, triangle, dp);
        int move1 = minimumTotal(row + 1, col + 1, m, triangle, dp);
        int cost = Math.min(move1, move2) + triangle.get(row).get(col);

        dp[row][col] = cost;
        return cost;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        return minimumTotal(0, 0, m, triangle, dp);
    }
}