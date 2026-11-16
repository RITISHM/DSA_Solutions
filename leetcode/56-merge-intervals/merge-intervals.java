class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            int min = intervals[i][0];
            int max = intervals[i][1];
            while (i+1 < intervals.length && max >= intervals[i+1][0]){
                max = Math.max(intervals[i+1][1], max);
                i++;
            }
            res.add(new int[] {min, max});
        }

        return res.toArray(new int[res.size()][]);
    }
}