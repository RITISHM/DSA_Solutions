class Solution {
    class Pair{
        int m;
        int n;
        Pair(int m, int n){
            this.m = m;
            this.n = n;
        }
    }


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue <Pair> levels = new LinkedList<>();
        Pair pair ;
        boolean isEmpty = true;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    pair = new Pair(i, j);
                    levels.offer(pair);
                }
                if(grid[i][j] != 0) isEmpty = false;
            }
        }

        if (isEmpty) return 0;

        int ans = 0;

        while (!levels.isEmpty()){
            
            int size = levels.size();
            for(int i = 0; i < size; i++){
                Pair curr = levels.poll();
                

                //check down
                if (curr.m+1 < m && grid[curr.m + 1][curr.n] % 2 !=0){
                    Pair newPair = new Pair(curr.m + 1, curr.n);
                    grid[curr.m + 1][curr.n]=2;
                    levels.offer(newPair);
                }
                //check down
                if (curr.m-1 >= 0 && grid[curr.m - 1][curr.n] % 2 !=0){
                    Pair newPair = new Pair(curr.m - 1, curr.n);
                    grid[curr.m - 1][curr.n]=2;
                    levels.offer(newPair);
                }
                //check right
                if (curr.n + 1 < n && grid[curr.m][curr.n + 1] % 2 !=0){
                    Pair newPair = new Pair(curr.m, curr.n + 1);
                    grid[curr.m][curr.n + 1]=2;
                    levels.offer(newPair);
                }
                //check left
                if (curr.n-1 >= 0 && grid[curr.m][curr.n -1] % 2 !=0){
                    Pair newPair = new Pair(curr.m, curr.n - 1);
                    grid[curr.m][curr.n - 1]=2;
                    levels.offer(newPair);
                }
            }
            
            if (!levels.isEmpty()) ans++;
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    ans = -1;
                    break;
                }
            }
        }

        return ans;

    }
}