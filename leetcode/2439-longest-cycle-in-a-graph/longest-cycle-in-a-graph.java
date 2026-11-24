class Solution {
    private int[] dfs(int curr, int[] edges,boolean[] visited, Set<Integer> currPath){
        if(edges[curr] == -1) return new int[] {-1,-1};
        if (currPath.contains(curr)) return new int[]{curr, 0};
        if (visited[curr]) return new int[] {-1,-1};

        visited[curr] = true;
        currPath.add(curr);
        int[] ret = dfs(edges[curr], edges, visited, currPath);
        currPath.remove(curr);
        if (ret[0] != -1){
            if (ret[0] == curr){
                ret[0]= -1;
            }
            ret[1]++;
        }
        return ret;
    }
    public int longestCycle(int[] edges) {
        int max = -1;
        boolean[] visited = new boolean[edges.length];

        for(int i = 0; i < edges.length; i++){
            if(edges[i] == -1 || visited[i]) continue;
            Set <Integer> currPath = new HashSet<>();
       
            max = Math.max(max, dfs(i, edges, visited, currPath)[1]);
        }
        return max;
    }
}