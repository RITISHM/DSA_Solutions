class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false ;

        int n = nums.length;
        int [] nge = new int [n];
        int [] lse = new int [n];
        Stack <Integer> st = new Stack<>();

        for (int i = 0; i < n ; i++ ){
            while (!st.isEmpty() && nums[i] <= st.peek()) st.pop();

            if (st.isEmpty()) lse[i] = Integer.MIN_VALUE;
            else lse[i] = st.peek();
            
            st.push(nums[i]);
        }

        while (!st.isEmpty()) st.pop();

        for (int i = n-1; i >= 0; i-- ){
            while (!st.isEmpty() && nums[i] >= st.peek()) st.pop();

            if (st.isEmpty()) nge[i] = Integer.MIN_VALUE;
            else nge[i] = st.peek();
            
            st.push(nums[i]);
        }
    

        for (int i = 0; i < n; i++){
            if (lse[i] != Integer.MIN_VALUE && nge[i] != Integer.MIN_VALUE)return true;
        }


        return false;
    }
}