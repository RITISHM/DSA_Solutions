// Note: we will take the right part and then put it on the right most side of the left part and do this untill each node is processed.

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;
        while(curr != null) {
            TreeNode rightMost = curr.left;

            //if the left of the curr is null
            if (rightMost == null) {
                curr = curr.right;
                continue;
            }

            //now we will transverse to the right most node
            while (rightMost != null && rightMost.right != null){
                rightMost = rightMost.right;
            }

            //we will put the right of the curr to rightMost right
            rightMost.right = curr.right;

            //we will point the right reference of the curr to its left
            curr.right = curr.left;
            
            //we will clear the left reference to null as we have relocated the left as needed
            curr.left = null;

            //we will now move the curr to the right as the next node need to be processed
            curr = curr.right;
        }

    }
}