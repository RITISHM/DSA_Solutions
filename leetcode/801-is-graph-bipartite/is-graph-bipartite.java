class Solution {
    
    public boolean dfs(int node, int [][] adj, char color, boolean [] visited, char [] colors){
        char nextColor = ( color == 'X') ? 'O' : 'X';
        for(int i = 0; i < adj[node].length; i++){
            int nextNode = adj[node][i];

            if(visited[nextNode] && (colors[nextNode] == color)) {
                return false;
            }

            if(!visited[nextNode]){
                colors[nextNode] = nextColor;
                visited[nextNode] = true;
                if(!dfs(nextNode, adj, nextColor, visited, colors)){
                     return false;
                }
            }
        }
        return true;
        
    } 

    public boolean isBipartite(int[][] graph) {
        
        boolean[] visited = new boolean[graph.length];
        char [] colors = new char[graph.length]; 
        
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                visited[i] = true;
                colors[i] = 'X';
                if(!dfs(i, graph, 'X', visited, colors)) return false;
            }
        }

        return true;
    }
}