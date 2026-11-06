class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (k == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += cardPoints[i];
            return sum;
        }
        int curr = 0;
        int res = 0;
        for (int i = 0; i < k; i++){
            curr += cardPoints[i];
        }
        res = curr;

        for (int i = 0; i < k; i++){
            curr += cardPoints[n - 1 - i];
            curr -= cardPoints[k - 1 - i];
            res = Math.max(res, curr);
        }

        return res;
    }
}