class Solution {

    public void helper(int num, int currIndex, int [] digits, boolean[] visited, Set<Integer> allPermute){
        if(num >= 100 && num < 1000){
            allPermute.add(num);
            return;
        }
        
        for(int i = 0; i < digits.length; i++){
           
            if (!visited[i]){
                visited[i] = true;
                helper(num*10+digits[i], i, digits, visited, allPermute);
                visited[i] = false;
            }
        }
    }

    public int totalNumbers(int[] digits) {
        boolean[] visited = new boolean[digits.length];
        Set <Integer> allPermute = new HashSet<>();
        for(int i = 0; i < digits.length; i++){
            visited[i] = true;
            helper(digits[i], i, digits, visited, allPermute);
            visited[i] = false;
        }
        int count = 0;
        for(int i : allPermute){
            if (i%2 == 0) count++;
        }
        return count;
    }
}