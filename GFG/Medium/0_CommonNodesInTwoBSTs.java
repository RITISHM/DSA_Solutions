/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};*/

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList <Integer> res = new ArrayList<>();
        Stack <Node> st1 = new Stack<>();
        Stack <Node> st2 = new Stack<>();
        
        while (r1 != null){
                st1.push(r1);
                r1 = r1.left;
            }
            
        while (r2 != null){
            st2.push(r2);
            r2 = r2.left;
        }
         
            
        while ( !st1.isEmpty() && !st2.isEmpty()){
            
            if (st1.peek().data == st2.peek().data){
                res.add(st1.peek().data);
                r1 = st1.pop().right;
                r2 = st2.pop().right;
            }
            
            else if(st1.peek().data < st2.peek().data){
                r1 = st1.pop().right;
            }
            
            else{
                r2 = st2.pop().right;
            }
            
            while (r1 !=null){
                st1.push(r1);
                r1 = r1.left;
            }
            
            while (r2 != null){
                st2.push(r2);
                r2 = r2.left;
            }
            
        }
        
        return res;
    }
}
