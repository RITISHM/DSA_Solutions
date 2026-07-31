class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet <Integer> a = new HashSet();
        HashSet <Integer> b = new HashSet();

        for (int i : nums1) a.add(i);
        for (int i : nums2) b.add(i);


        for(int i = 0; i < nums2.length; i++){
            if (a.contains(nums2[i])) a.remove(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            if (b.contains(nums1[i])) b.remove(nums1[i]);
        }
        
        List <Integer> res1 = new ArrayList<>(a);
        List <Integer> res2 = new ArrayList<>(b);

        List<List<Integer>> res = new ArrayList<>();
        res.add(res1);
        res.add(res2);
        
        return res;
    }
}