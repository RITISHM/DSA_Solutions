import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build adjacency list and in-degree array
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            matrix.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            matrix.get(prereq).add(course); // prereq -> course
            inDegree[course]++;             // course depends on prereq
        }
        
        // 2. Add all nodes with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 3. Process the graph using BFS
        int completedCourses = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;
            
            // Reduce in-degree for all neighboring courses
            for (int neighbor : matrix.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 4. If we processed all courses, there is no cycle
        return completedCourses == numCourses;
    }
}