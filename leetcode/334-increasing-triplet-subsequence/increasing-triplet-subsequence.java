class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false ;

        int n = nums.length;
        long [] nge = new long [n];
        long [] lse = new long [n];
        Stack <Long> st = new Stack<>();

        for (int i = 0; i < n ; i++ ){
            while (!st.isEmpty() && nums[i] <= st.peek()) st.pop();

            if (st.isEmpty()) lse[i] = Long.MIN_VALUE;
            else lse[i] = st.peek();
            
            st.push((long) nums[i]);
        }

        while (!st.isEmpty()) st.pop();

        for (int i = n-1; i >= 0; i-- ){
            while (!st.isEmpty() && nums[i] >= st.peek()) st.pop();

            if (st.isEmpty()) nge[i] = Long.MIN_VALUE;
            else nge[i] = st.peek();
            
            st.push((long) nums[i]);
        }
    

        for (int i = 0; i < n; i++){
            if (lse[i] != Long.MIN_VALUE && nge[i] != Long.MIN_VALUE)return true;
        }


        return false;
    }
}