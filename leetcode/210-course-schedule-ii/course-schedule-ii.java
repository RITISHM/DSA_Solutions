class Solution {
    
    public void createAdj(int numCourses, int [][] prerequisites, ArrayList<ArrayList<Integer>> adjList){
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites){
            int edgeFrom = prerequisite[1];
            int edgeTo = prerequisite[0];
            adjList.get(edgeFrom).add(edgeTo);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        Queue <Integer> nodes = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        createAdj(numCourses, prerequisites, adjList);

        for (int i = 0; i < numCourses; i++){
            for (int j : adjList.get(i)){
                inDegree[j]++;
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) nodes.offer(i);
        }

        int[] res = new int[numCourses];
        int ptr = 0;

        while(!nodes.isEmpty()){
            int node =  nodes.poll();
            res[ptr++] = node;

            for(int i : adjList.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    nodes.offer(i);
                }

            }
        }  
        if (ptr < numCourses) return new int [0];
        return res;
    }
}