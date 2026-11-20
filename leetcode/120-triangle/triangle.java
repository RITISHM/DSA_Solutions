class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++){
            dp[i] = triangle.get(m-1).get(i);
        }

        for (int row = m - 2; row >= 0; row--){
            for (int col = 0; col <= row; col++){
                int move1 = dp[col];
                int move2 = dp[col + 1];
                int cost = Math.min(move1, move2) + triangle.get(row).get(col);
                dp[col] = cost;
            }
        }
        return dp[0];
    }
}