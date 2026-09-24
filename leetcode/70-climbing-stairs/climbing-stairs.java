class Solution {
    int[] way;
    int ways(int n){
        if (n < 0) return 0;
        if (n < 1) return 1;
        if (way[n] != -1) return way[n];

        way[n] = ways(n - 1) + ways(n - 2);

        return way[n];
    }
    public int climbStairs(int n) {
        way = new int[n+1];
        Arrays.fill(way,-1);
        return ways(n);
    }
}