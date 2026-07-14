

class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public List[] creatAdj( int v, int[][] edges){
        List <Integer> [] mat = new List [v];
        for (int i=0; i<v; i++)mat[i]= new ArrayList<>();
        
        for (int [] edge : edges){
            int i = edge[0];
            int j = edge[1];
            mat[i].add(j);
            
        }
        return mat;
    }
    
    boolean checkCycle(List <Integer>[] adjMat , int src, boolean [] visited, boolean [] inStack){
        visited[src]= true;
        inStack[src] = true;

        for ( int i : adjMat [src]){
            if (!visited[i]){
            if (checkCycle (adjMat, i, visited, inStack)) return true;
            }
            else if (inStack[i]){
                return true;
            }
        }
        inStack[src] = false;
        return false;
        
    }
    
    public boolean canFinish(int V, int[][] edges) {
        
        List [] adjMat = creatAdj(V , edges);
        boolean [] visited = new boolean [V];
        boolean [] inStack = new boolean [V];
        for(int i= 0; i< V; i++){
            if (visited[i] || adjMat[i] == null)continue;
            if (checkCycle(adjMat, i, visited, inStack)) return false;
        }
        
        return true;
        
    }
}