class Solution {
    private boolean canCross(int index, int lastJump, int[] stones, int[][] dp, HashMap<Integer, Integer> map) {
        if (index == stones.length - 1)
            return true;

        if (dp[index][lastJump] != -1)
            return dp[index][lastJump] == 1 ? true : false;

        int curr = stones[index];
        boolean res = false;
        boolean next = map.containsKey(curr + lastJump + 1);
        if (next) {
            int nextIndex = map.get(curr + lastJump + 1);
            res = res || canCross(nextIndex, lastJump + 1, stones, dp, map);
        }

        next = map.containsKey(curr + lastJump);
        if (next) {
            int nextIndex = map.get(curr + lastJump);
            res = res || canCross(nextIndex, lastJump, stones, dp, map);
        }

        if (lastJump - 1 > 0) {
            next = map.containsKey(curr + lastJump - 1);
            if (next) {
                int nextIndex = map.get(curr + lastJump - 1);
                res = res || canCross(nextIndex, lastJump - 1, stones, dp, map);
            }
        }

        dp[index][lastJump] = res ? 1 : 0;
        return res;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        int[][] dp = new int[stones.length][stones.length];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        return canCross(1, 1, stones, dp, map);
    }
}