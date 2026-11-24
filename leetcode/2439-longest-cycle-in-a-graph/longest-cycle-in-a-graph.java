class Solution {
    public int longestCycle(int[] edges) {
        int [] indegree = new int[edges.length];
        for(int i : edges){
            if (i == -1) continue;
            indegree[i]++;
        }

        boolean[] visited = new boolean[edges.length];
        Queue<Integer>  q = new LinkedList<>();
        for (int i = 0; i < edges.length; i++){
            if (indegree[i] == 0)q.add(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            int next = edges[curr];
            if(next == -1) continue;

            indegree[next]--;
            if (indegree[next]==0)q.add(next);
        }
        int res = -1;
        for (int i = 0; i < edges.length; i++){
            if(visited[i]) continue;
            int length =0;
            int curr = i;

            while(edges[curr] != -1){
                if (visited[curr]){
                    res = Math.max(res, length);
                    break;
                }
                length ++;
                visited[curr] = true;
                curr = edges[curr];
            }
        }
        return res;
    }
}