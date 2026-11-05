/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxColumn;
    int minColumn;

    class Node{
        int col;
        TreeNode node;
        Node(int col, TreeNode node){
            this.col = col;
            this.node = node;
        }
    }

    void traversal(TreeNode root, HashMap <Integer, List<Integer>> map){
        if (root == null) return;

        Queue <Node> q = new LinkedList<>();
        q.add(new Node(0, root));

        while(!q.isEmpty()) {
            int size = q.size();
            HashMap <Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++){
                Node curr = q.poll();
                int col = curr.col;
                TreeNode node = curr.node;
                minColumn = Math.min(col, minColumn); 
                maxColumn = Math.max(col, maxColumn); 

                if (!levelMap.containsKey(col)) levelMap.put(col, new ArrayList<>());
                levelMap.get(col).add(node.val);

                if (node.right != null){
                    q.add(new Node(col + 1, node.right));
                }
                if (node.left != null){
                    q.add(new Node(col - 1, node.left));
                }
            }
            for (int i : levelMap.keySet()){
                Collections.sort(levelMap.get(i));
                
                if (!map.containsKey(i)) map.put(i, new ArrayList<>());
                map.get(i).addAll(levelMap.get(i));
            }
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        maxColumn = 0;
        minColumn = 0;
        HashMap <Integer, List<Integer>> map = new HashMap<>();
        traversal(root, map);
        List<List<Integer>> res = new ArrayList<>();


        for (int i = minColumn; i <= maxColumn; i++){
            res.add(map.get(i));
        }

        return res;
    }
}