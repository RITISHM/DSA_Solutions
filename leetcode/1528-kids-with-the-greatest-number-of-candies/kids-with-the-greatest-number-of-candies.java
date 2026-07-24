class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
     List <Boolean> res = new ArrayList<>();
     int max = candies[0];

     for (int i = 0; i < candies.length; i++){
        if (candies[i] > max) max = candies[i];
     }   

     for (int i = 0; i < candies.length; i++){
        int totalCandies = candies[i] + extraCandies;
        res.add((totalCandies >= max));
     }

     return res;
    }
}