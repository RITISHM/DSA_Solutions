class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer, Set<Integer>> dp = new HashMap<>();

        for (int i : stones) {
            dp.put(i, new HashSet<>());
        }
        dp.get(0).add(0);

        for (int key : stones) {
            for (int lastJump : dp.get(key)) {
                if (lastJump - 1 > 0 && dp.containsKey(lastJump - 1 + key)) {
                    dp.get(lastJump - 1 + key).add(lastJump - 1);
                }
                if (dp.containsKey(lastJump + key)) {
                    dp.get(lastJump + key).add(lastJump);
                }
                if (dp.containsKey(lastJump + 1 + key)) {
                    dp.get(lastJump + 1 + key).add(lastJump + 1);
                }
                if (dp.get(stones[n - 1]).size() > 0) {
                    return true;
                }
            }
        }
        return false;

    }
}