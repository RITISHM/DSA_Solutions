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
    
    int max;

    int helper(TreeNode root){
        if (root == null) return 0;
        int curr = root.val;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int currPathSum = curr + left + right;
        max = Math.max(currPathSum, max);
        return curr + Math.max(left, right);
    }
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
}