class Solution {

    void createMatrix(int[][] prerequisites, List<List<Integer>> matrix){
        for(int[] prerequisite : prerequisites){
            int j = prerequisite[0];
            int i = prerequisite[1];
            matrix.get(i).add(j);
        }
    }


    public boolean dfs(int course, List<List<Integer>> matrix, Set<Integer> set,boolean[] visited){
        
        for(int i = 0; i < matrix.get(course).size(); i++ ){
            int current = matrix.get(course).get(i);
            if(set.contains(current)) return false;
            if(visited[current]) continue;

            set.add(current);
            visited[current] = true;
            if(!dfs(current, matrix, set, visited)) return false;
            set.remove(current);
        }
        

        return true;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> matrix = new ArrayList<>();

        for(int i= 0; i < numCourses; i++){
            matrix.add(new ArrayList<>());
        }   

        createMatrix(prerequisites, matrix);
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++ ){
            if(visited[i]) continue;

            Set <Integer> set = new HashSet<>();
            set.add(i);
            visited[i] = true;

            if(!dfs(i, matrix, set, visited))return false;

        }
        return true;
    }
}