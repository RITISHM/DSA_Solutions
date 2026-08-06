class Solution {

 

    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        int [][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean [][] visited = new boolean [rows][cols];
        Queue<int []> nodes = new LinkedList<>();

        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col++){
                boolean invalid = false;
                if(board[row][col] == 'O'){
                    for(int [] dir:dirs){
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        if( nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                            invalid = true;
                            break;
                        }
                    }
                }

                if(invalid){
                    visited[row][col] = true;
                    nodes.offer(new int []{row, col});
                }
            }
        }




        while(!nodes.isEmpty()){
       
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                int [] node = nodes.poll();
                int row = node[0];
                int col = node[1]; 
                for(int [] dir:dirs){
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if( nextRow >= 0 && nextRow < rows &&
                     nextCol >= 0 && nextCol < cols && 
                     !visited[nextRow][nextCol] && board[nextRow][nextCol] == 'O') {
                        visited[nextRow][nextCol] = true;
                        nodes.add(new int []{nextRow, nextCol});
                    }
                }
            }
        }



        
        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col++){
                if(!visited[row][col]) board[row][col] = 'X';
            }
        }
    
    }
}