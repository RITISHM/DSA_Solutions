/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode current ;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int n = 0;
        current = head;
        while (head != null) {
            n++;
            head = head.next;
        }

        return buildBst (0, n-1);

    }

    TreeNode buildBst(int start, int end){
        if (start > end) return null;

        int mid = start + (end - start)/2;

        TreeNode left = buildBst(start, mid -1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = buildBst(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}