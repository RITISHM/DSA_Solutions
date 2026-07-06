/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int srcColor = image [sr][sc];
        int m = image.length, n= image[0].length;
        int [][] dirs = {{1, 0},{-1, 0}, {0, 1}, {0, -1}};
        
        if (srcColor == newColor) return image;
        
        Queue <int []> bfs = new LinkedList <>();
        bfs.offer(new int [] {sr,sc});
        
        while (!bfs.isEmpty()){
            int size = bfs.size();
            for(int i = 0 ; i < size; i++){
            int [] curr = bfs.poll();
            int currR = curr[0], currC = curr[1];
            image [currR][currC] = newColor;
            
            for (int [] dir : dirs){
                int row = currR - dir[0];
                int col = currC - dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && image[row][col] == srcColor )
                    bfs.offer(new int [] {row, col});
            }
            }
            
        }
        
        return image;
        
    }
}
