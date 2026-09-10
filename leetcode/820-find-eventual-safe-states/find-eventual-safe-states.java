class Solution {

    public List<List<Integer>> createReverseAdj(int [][] graph){
        List<List<Integer>> reversedGraph = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++){
            for (int j : graph[i]){
                reversedGraph.get(j).add(i);
            }
        }
        
         return reversedGraph;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
 
        List<List<Integer>> reversedGraph = createReverseAdj(graph);

        int[] outdegree = new int [graph.length];

        for (int i = 0; i < graph.length; i++){
            outdegree[i] = graph[i].length;
        } 

        Queue <Integer> nodes = new LinkedList<>();

        for (int i = 0; i < outdegree.length; i++){
            if(outdegree[i] == 0) nodes.add(i);
        }

        List<Integer> res = new ArrayList<>();

        while(!nodes.isEmpty()){
            int node = nodes.poll();
            res.add(node);

            for (int i : reversedGraph.get(node)){
                outdegree[i]--;
                if(outdegree[i] == 0) nodes.add(i);
            }
        }

        Collections.sort(res);
        return res;
    }
}