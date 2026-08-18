class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build adjacency list (graph)
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            matrix.add(new ArrayList<>());
        }   
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            matrix.get(prereq).add(course); // prereq -> course
        }

        // 0 = unvisited, 1 = visiting (in current path), 2 = visited (safe)
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!hasCycle(i, matrix, visited)) {
                    return false; // Cycle detected
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> matrix, int[] visited) {
        if (visited[course] == 1) return false; // Cycle found in current path
        if (visited[course] == 2) return true;  // Already checked and safe

        visited[course] = 1; // Mark as visiting

        for (int nextCourse : matrix.get(course)) {
            if (!hasCycle(nextCourse, matrix, visited)) {
                return false;
            }
        }

        visited[course] = 2; // Mark as fully visited/safe
        return true;
    }
}