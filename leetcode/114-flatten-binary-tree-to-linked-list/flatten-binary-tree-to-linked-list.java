class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;
        while (curr != null) {
            // If there is no left child, we can just move to the right subtree
            if (curr.left == null) {
                curr = curr.right;
                continue;
            }

            // Find the rightmost node of the left subtree (the in-order predecessor)
            TreeNode predecessor = curr.left;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }

            // Connect the original right subtree to the rightmost node of the left subtree
            predecessor.right = curr.right;

            // Move the entire left subtree to the right side
            curr.right = curr.left;
            
            // Clear the left reference
            curr.left = null;

            // Move to the next node
            curr = curr.right;
        }
    }
}