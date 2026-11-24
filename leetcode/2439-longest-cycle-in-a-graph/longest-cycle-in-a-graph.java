class Solution {
    private int dfs(int curr, int seen, int[] edges,int[] visited, Set<Integer> currPath){
        if(edges[curr] == -1) return -1;
        if (currPath.contains(curr)) return seen - visited[curr];
        if (visited[curr]!= 0) return -1;

        currPath.add(curr);
        visited[curr] = seen;
        int ret = dfs(edges[curr], ++seen, edges, visited, currPath);
        currPath.remove(curr);
        return ret;
    }
    public int longestCycle(int[] edges) {
        int max = -1;
        int[] visited = new int[edges.length];
        // Arrays.fill(visited, 1);
        for(int i = 0; i < edges.length; i++){
            if(edges[i] == -1 || visited[i] != 0) continue;
            Set <Integer> currPath = new HashSet<>();
       
            max = Math.max(max, dfs(i, 1, edges, visited, currPath));
        }
        return max;
    }
}