class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue <Long> heap = new PriorityQueue<>();
        Set <Long> set = new HashSet<>();
        heap.add(1L);
        set.add(1L);
        for(int i = 1 ; i < n ; i ++){
            long num = heap.poll();
            if(!set.contains(num*2)) {
                heap.add(num*2);
                set.add(num*2);
            }
            if(!set.contains(num*3)) {
                heap.add(num*3);
                set.add(num*3);
            }
            if(!set.contains(num*5)) {
                heap.add(num*5);
                set.add(num*5);
            }
        }
    int val = Math.toIntExact( heap.poll());
        return val;

    }
}