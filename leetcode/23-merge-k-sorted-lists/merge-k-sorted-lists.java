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
    

  public ListNode mergeKLists(ListNode [] lists){
    if (lists.length == 0) return null;
    ListNode a = lists[0];
    
    for (int i = 1; i < lists.length; i++){
      ListNode b = lists[i];
     
      ListNode newHead = new ListNode();
        ListNode curr = newHead;
        ListNode ptr1 = a;
        ListNode ptr2 = b;

        while(ptr1 != null && ptr2 != null){
        if(ptr1.val < ptr2.val){
            curr.next = ptr1;
            ptr1 = ptr1.next;
            curr = curr.next;
        }

        else{
            curr.next = ptr2;
            ptr2 = ptr2.next;
            curr = curr.next;
        }
        }

        while (ptr1 != null){
            curr.next = ptr1;
            ptr1 = ptr1.next;
            curr = curr.next;
        }

        while (ptr2 != null){
            curr.next = ptr2;
            ptr2 = ptr2.next;
            curr = curr.next;
        }
        a = newHead.next;

    }

    return a;

  }
}