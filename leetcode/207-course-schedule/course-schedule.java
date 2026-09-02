class Solution {

    public void createAdj(int numCourses, int [][] prerequisites, ArrayList<ArrayList<Integer>> adjMatrix){
        for (int i = 0; i < numCourses; i++){
            adjMatrix.add( new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int fromEdge = prerequisite[1];
            int toEdge = prerequisite[0];
            adjMatrix.get(fromEdge).add(toEdge);
        }
    }


    

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        createAdj(numCourses, prerequisites, adjMatrix);

        int [] inDegree = new int[numCourses];
        int res = 0;

        for(int i = 0 ; i < numCourses; i++){
            for (int j : adjMatrix.get(i)){
                inDegree[j]++;
            }
        }   

        Queue <Integer> nodes = new LinkedList<>();     

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                nodes.offer(i);
            }
        }

        while(!nodes.isEmpty()){
            int node = nodes.poll();
            res++;

            for(int j : adjMatrix.get(node)){
                inDegree[j]--;
                if (inDegree[j] == 0) nodes.offer(j);
            }

        }

        return (res == numCourses);
    }
}