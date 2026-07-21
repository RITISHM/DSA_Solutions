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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headP = head;
        ListNode lessHead = new ListNode(-1);
        ListNode lessP = lessHead;
        ListNode greatHead = new ListNode(-1);
        ListNode greatP = greatHead;

        while (headP != null){
            if (headP.val < x) {
                lessP.next = headP;
                lessP = lessP.next;
            }
            else{
                greatP.next = headP;
                greatP = greatP.next;
            }
            headP = headP.next;                
        }

        lessP.next = greatHead.next;
        greatP.next = null;
        return lessHead.next;
    }
}