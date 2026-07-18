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
    class Pair{
        TreeNode node;
        String side;

        Pair(TreeNode node, String side){
            this.node =node;
            this.side=side;
        }
    }


    public int findBottomLeftValue(TreeNode root) {
            
            Queue <TreeNode> levels = new LinkedList<>();
            int res = -1;
            levels.offer(root);

            while(!levels.isEmpty()){
            
            int size = levels.size();

            for (int i = 1; i <= size; i++){

                TreeNode curr = levels.poll();

                if (i == size ) res = curr.val;

                if (curr.right != null) levels.offer(curr.right);
                if (curr.left != null) levels.offer(curr.left);

            }

            }
            
            return res;
    }
}