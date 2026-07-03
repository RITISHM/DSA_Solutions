class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length == 0 || image[0].length == 0) return image;

        int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int scolor = image [sr][sc];

        if (scolor == color)return image;

        Queue <int []> flooded_node = new LinkedList<>();
        flooded_node.offer(new int[] {sr, sc});

        while(!flooded_node.isEmpty()){
            int size = flooded_node.size();
            for (int i = 0; i < size; i++){
                int [] curr = flooded_node.poll();
                image[curr[0]][curr[1]]=color;

                for (int j = 0; j < dir.length; j++ ){
                    int currRow = curr[0] + dir[j][0];
                    int currCol = curr[1] + dir[j][1];
                    if (currRow  >= 0 && currRow < image.length  && currCol >= 0 && currCol < image[0].length && image[currRow][currCol] == scolor){
                        flooded_node.offer(new int[] {currRow, currCol});

                    }
                } 
            } 

        }

        return image ;
        
    }
}