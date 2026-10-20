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
   

    TreeNode helper(ListNode start, ListNode last){
        if(start == null || start == last) return null;
        ListNode slow = start; 
        ListNode fast = start;

        while(fast != last && fast.next != last){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(start, slow);
        root.right = helper(slow.next, last);
        return root;
    }


    public TreeNode sortedListToBST(ListNode head) {
        return helper(head , null);
    }
}