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
    PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

    for (int i = 0; i < lists.length; i++){
        if (lists[i] != null)
        queue.add(lists[i]);
    }

    ListNode newHead = new ListNode();
    ListNode curr = newHead;

    while(!queue.isEmpty()){
        curr.next = queue.poll();
        curr = curr.next;
        if (curr.next != null){
            queue.add(curr.next);
        }
    }
    

    return newHead.next;

  }
}