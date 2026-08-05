class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srcColor = image[sr][sc];
        int[][] dirs = {{0 , 1}, {1, 0}, {-1, 0}, {0, -1}};
        if(image[sr][sc] == color) return image;
        image[sr][sc] = color;

        Queue<int[]> nodes = new LinkedList<>();

        nodes.offer(new int[] {sr, sc});

        while(!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++){
                int [] node = nodes.poll();
                int row = node[0];
                int col = node[1];
                for(int [] dir : dirs){
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if (nextRow >= 0 && nextRow < image.length && nextCol >= 0 && nextCol < image[0].length && image[nextRow][nextCol] == srcColor){
                        nodes.offer(new int[] {nextRow , nextCol});
                        image[nextRow][nextCol] = color;
                    }
                }
            }
        } 

        return image;

        

    }
}