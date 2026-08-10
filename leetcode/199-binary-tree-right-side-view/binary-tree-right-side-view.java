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
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue <TreeNode> levels = new ArrayDeque<>();
        levels.offer(root);
        
        while(!levels.isEmpty()){
            int size = levels.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = levels.poll();
                if(i == size - 1) res.add(curr.val);
                if(curr.left != null) levels.offer(curr.left);
                if(curr.right != null) levels.offer(curr.right);
            }

        }
        return res;
    }
}