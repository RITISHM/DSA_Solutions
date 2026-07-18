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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list=new ArrayList<>();
        if (root==null)return list;
        Queue <TreeNode>q=new LinkedList<>();
        q.offer(root);
        int count =0;
        while (!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                level.add(curr.val);
                if (curr.left!=null)q.offer(curr.left);
                if (curr.right!=null)q.offer(curr.right);
            }
            if (count++%2==1)
               list.add(level.reversed());
            else
            list.add(level);

        }
        return list;
    }
}