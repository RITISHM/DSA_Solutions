class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Set<Integer> [] dp = new HashSet[n];

        for (int i = 0; i < n; i++){
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);
        for (int i = 0; i < n; i++) {
            for (int lastJump : dp[i]) {
                int key = stones[i];
                int jump1 = Arrays.binarySearch(stones,lastJump - 1 + key);
                int jump2 = Arrays.binarySearch(stones,lastJump  + key);
                int jump3 = Arrays.binarySearch(stones,lastJump + 1 + key);

                if (lastJump - 1 > 0 && jump1 >= 0){
                    dp[jump1].add(lastJump - 1);
                }
                if (jump2 > 0){
                    dp[jump2].add(lastJump);
                }

                if (jump3 > 0){
                    dp[jump3].add(lastJump + 1);
                }
        
                if (dp[n-1].size() > 0) {
                    return true;
                }
            }
        }
        return false;

    }
}