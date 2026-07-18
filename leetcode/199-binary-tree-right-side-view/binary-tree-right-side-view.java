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

        Queue <TreeNode> levels = new LinkedList<>();
        List <Integer> res = new ArrayList<>();

        if (root == null) return res;
        levels.offer(root);

        while (!levels.isEmpty()){
            int size = levels.size();
            for (int i = 1; i <= size; i++){

                TreeNode curr = levels.poll();

                if (i==size) res.add(curr.val);

                if (curr.left != null) levels.offer(curr.left);
                
                if (curr.right != null) levels.offer(curr.right);

            }
        }
        return res;
    }
}