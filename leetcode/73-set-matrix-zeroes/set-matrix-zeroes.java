class Solution {


    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] visitedRows = new boolean[rows];
        boolean[] visitedCols = new boolean[cols];


        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == 0){
                    visitedRows[row] = true;
                    visitedCols[col] = true;
                }
            }
        }
        

        for(int row = 0; row < rows; row++){
            if(visitedRows[row]){
                for(int col = 0; col < cols; col++){
                    matrix[row][col] = 0;
                }
            }
        }
        for(int col = 0; col < cols; col++){
            if(visitedCols[col]){
                for(int row = 0; row < rows; row++){
                    matrix[row][col] = 0;
                }
            }
        }
    }
}