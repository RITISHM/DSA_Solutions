class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean [][] visited = new boolean [mat.length][mat[0].length];

        Queue <Pair> levels = new LinkedList<>();
        
        
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++ ){
               
                if (mat[i][j] == 0) {

                    Pair curr = new Pair(i, j);
                    levels.offer(curr);
                    visited[i][j] = true;

                }
            }
        }

        while (!levels.isEmpty()){
            int size = levels.size();

            for (int k = 0; k < size; k++){
                Pair currNode = levels.poll();
                int currRow = currNode.row;
                int currCol = currNode.col;

                for (int [] dir : dirs){
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if (nextRow >= 0 && nextRow < mat.length &&
                        nextCol >= 0 && nextCol < mat[0].length && 
                        !visited[nextRow][nextCol])
                     {

                        Pair nextNode = new Pair(nextRow,nextCol);
                        levels.offer(nextNode);
                        mat[nextRow][nextCol] = mat[currRow][currCol] + 1;
                        visited[nextRow][nextCol] = true;
                    }
                }

            }
        }


        return mat;
    }
}