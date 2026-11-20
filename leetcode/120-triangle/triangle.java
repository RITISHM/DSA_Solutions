class Solution {
    private int minimumTotal(int row, int col, int m, List<List<Integer>> triangle, List<List<Integer>> dp){
        if (row == m - 1) return triangle.get(row).get(col);
        if (dp.get(row).get(col) != Integer.MAX_VALUE) return dp.get(row).get(col);

        int move2 = minimumTotal(row + 1, col, m, triangle, dp);
        int move1 = minimumTotal(row + 1, col + 1, m, triangle, dp);
        int cost = Math.min(move1, move2) + triangle.get(row).get(col);

        dp.get(row).set(col, cost);
        return cost;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for (int row = 0; row < m; row++){
            int n = triangle.get(row).size();
            dp.add(new ArrayList<>());
            for(int col = 0; col < n; col++){
                dp.get(row).add(Integer.MAX_VALUE);
            }
        }

        return minimumTotal(0, 0, m, triangle, dp);
    }
}