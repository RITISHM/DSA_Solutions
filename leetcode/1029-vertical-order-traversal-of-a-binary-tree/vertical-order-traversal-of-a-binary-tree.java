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
    class Point implements Comparable<Point> {
        int row;
        int col;
        int val;
        Point(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

 
        public int compareTo( Point b) {
            if (this.col != b.col) return Integer.compare(this.col, b.col);
            else if (this.row != b.row) return Integer.compare(this.row, b.row);
            else return Integer.compare(this.val, b.val);
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> list = new ArrayList<>();

        dfs(root, 0, 0, list);

        Collections.sort(list);

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = -1000;
        List currList = null;

        for (Point point : list){
            if (point.col != prevCol){
                prevCol = point.col;
                currList = new ArrayList<>();
                res.add(currList);
            }

            currList.add(point.val);
        }
        return res;
    }

    void dfs(TreeNode root, int row, int col, List<Point> list){
        if (root == null) return;

        list.add(new Point(root.val, row, col));
        dfs(root.left, row + 1, col - 1, list);
        dfs(root.right, row + 1, col + 1, list);
    }
}