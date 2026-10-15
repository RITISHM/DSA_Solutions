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
    TreeNode construct (int [] nums, int left, int right){
        if (left > right) return null;
        int rootValueIndex = left + (right - left)/ 2;
        TreeNode root = new TreeNode(nums[rootValueIndex]);

        root.left = construct(nums, left, rootValueIndex - 1);

        root.right = construct(nums, rootValueIndex + 1, right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
}