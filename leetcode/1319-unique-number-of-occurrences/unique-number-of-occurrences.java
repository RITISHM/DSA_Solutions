class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer, Integer>  frequency = new HashMap<>();

        for (int i : arr){
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        Set <Integer> frequencies = new HashSet<>(frequency.values());
        
        return frequencies.size() == frequency.size();
            
    }
}