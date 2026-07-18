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
    int helper( TreeNode root, String  side){
        if (root == null) return 0;

        if (root.left ==null && root.right == null && side.equals("left")) return root.val;

        return helper(root.left, "left") + helper(root.right, "right");
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, "right");
    }
}