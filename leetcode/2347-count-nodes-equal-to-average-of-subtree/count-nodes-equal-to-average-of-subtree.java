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
    private int num;

    public int[] dfs (TreeNode root){
        if(root == null) return new int [] {0,0};

        int [] left = dfs(root.left);
        int [] right = dfs(root.right);

        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];
        int avg = sum / count;

        if(root.val == avg) num++;
        return new int [] {sum, count};

    }
    public int averageOfSubtree(TreeNode root) {
        num = 0;
        dfs(root);
        return num;
    }
}