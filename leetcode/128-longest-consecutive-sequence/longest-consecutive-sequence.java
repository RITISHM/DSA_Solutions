class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
    int res = 1;
    HashSet <Integer> set = new HashSet<>();

    //adding the numbers in set
    for (int i = 0; i < arr.length; i++ ){
      set.add(arr[i]);

    }

    //main 
    for (int i = 0; i < arr.length; i++){
      if (!set.contains(arr[i]))continue;
      
      int key = arr[i];
      int count = 1;


      //add the count and remove the numbers which are consecutive and grater to key
      while (set.contains(--key )){
        set.remove(key);
        count ++;
      }
      key = arr[i];
      
      //add the count and remove the numbers which are consecutive and smaller than key
      while (set.contains(++key)){
        set.remove(key);
        count ++;
      }

      //remove the key itself 
      set.remove(arr[i]);
      //update the result
      res = Math.max(count, res);
    }


    System.gc();
    return res;
    }
}